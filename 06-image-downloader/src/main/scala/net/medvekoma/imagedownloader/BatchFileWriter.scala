package net.medvekoma.imagedownloader

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

class BatchFileWriter(implicit asyncFileWriter: AsyncFileWriter, filenameProvider: FilenameProvider) {

  def writeFiles(urls: Set[String], targetFolder: String): Unit = {
    val futures = urls.map(url =>
      asyncFileWriter.write(url, filenameProvider.getFileName(url, targetFolder)))
    Await.result(Future.sequence(futures), 5.seconds)
    println("Done")
  }
}
