package net.medvekoma.imagedownloader

import scalaz.Reader

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

trait BatchFileWriter {

  def writeFiles(urls: Set[String], targetFolder: String): Reader[Config, Unit] =
    Reader((config: Config) => {
      val futures = urls.map(url =>
        config.asyncFileWriter.write(
          url,
          config.filenameProvider.getFileName(url, targetFolder)))
      Await.result(Future.sequence(futures), 5.seconds)
      println("Done")
    })
}
