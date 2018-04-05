# Handling Dependencies

If you follow SOLID principles in your coding - 
and particularly the Single Responsibility Principle - 
then you will end up soon with a bunch of software units that
depend on each other.

The domain of this example is an image downloader - it downloads
all pictures referenced in a website. A possible decomposition
and dependency graph could look like this:

![Units](doc/units.png)

We are looking for possibilities for implementing 
such a dependency graph so that 
* it is easy to instantiate, and
* the units are loosely coupled, and can be replaced.

## Cake pattern

Based on the idea that traits can be composed.

![Cake pattern](doc/cake.jpg)

* Implement all units as traits

* Define dependencies as self type annotations

```scala
trait OneService {
  this: SomeDependency with OtherDependency =>
  
  def oneFunction(): String = {
    val dep1 = someFunction()  // calling function from SomeDependency
    val dep2 = otherFunction() // calling function from OtherDependency
    dep1 + dep2.toString
  }
}
```

* Compose an app or module with all traits

```scala
object CakePattern extends SomeDependency with OtherDependency with OneService {
}
```

More info: [DI with the Cake pattern](http://jonasboner.com/real-world-scala-dependency-injection-di/)

## Classes and Constructors 

### Manual Dependency Injection

```scala
object TrainStation extends App {
   val pointSwitcher = new PointSwitcher()
   val trainCarCoupler = new TrainCarCoupler()
   val trainShunter = new TrainShunter(
      pointSwitcher, trainCarCoupler)

   val craneController = new CraneController()
   val trainLoader = new TrainLoader(
      craneController, pointSwitcher) 

   val trainDispatch = new TrainDispatch()

   val trainStation = new TrainStation(
     trainShunter, trainLoader, trainDispatch)

   trainStation.prepareAndDispatchNextTrain()
}
```

### Using implicit parameters

This approach is very similar to the manual dependency injection:
* It uses constructors with parameters
* Constructor parameters are declared `implicit`
* Dependencies are created as implicit variables

```scala
object TrainStation extends App {
   implicit lazy val pointSwitcher = new PointSwitcher
   implicit lazy val trainCarCoupler = new TrainCarCoupler
   implicit lazy val trainShunter = new TrainShunter

   implicit lazy val craneController = new CraneController
   implicit lazy val trainLoader = new TrainLoader

   implicit lazy val trainDispatch = new TrainDispatch

   implicit lazy val trainStation = new TrainStation

   trainStation.prepareAndDispatchNextTrain()
}
```

### Using MacWire

DI framework with a touch of Scala. 

```scala
object TrainStation extends App {
   lazy val pointSwitcher = wire[PointSwitcher]
   lazy val trainCarCoupler = wire[TrainCarCoupler]
   lazy val trainShunter = wire[TrainShunter]

   lazy val craneController = wire[CraneController]
   lazy val trainLoader = wire[TrainLoader] 
   lazy val trainDispatch = wire[TrainDispatch]

   lazy val trainStation = wire[TrainStation]

   trainStation.prepareAndDispatchNextTrain() 
}
```

Things to note:
* Scala macro - compile time verification, no runtime dependency is needed
* lazy val - Scala feature for late evaluation

More info: [DI with MacWire](http://di-in-scala.github.io)

## Dependencies as functions

In functional languages the natural unit of composition is - the function.
In a pure functional world we can simply compose functions.

### Composing unary functions

```scala
val imageUrls: String => Set[String] = PageReader.getImageUrls
val download: Set[String] => Unit = BatchFileWriter.writeFiles(_, "")
val downloadUrls = imageUrls andThen download
```

### Reader monad

The `scalaz.Reader` monad can wrap a unary function, and provides the regular
`map` and `flatMap` functions.

This allows using `map` instead of `andThen`, and also enables using for comprehension:

```scala
val imageUrls: String => Set[String] = Reader(PageReader.getImageUrls)
val download: Set[String] => Unit = Reader(BatchFileWriter.writeFiles(_, "")
val downloadUrls = imageUrls map download
// or also
for {
  images <- imageUrls(url)
  res <- download(images)
} yield res
```

Read more: [DI with the Reader monad](http://blog.originate.com/blog/2013/10/21/reader-monad-for-dependency-injection/)
