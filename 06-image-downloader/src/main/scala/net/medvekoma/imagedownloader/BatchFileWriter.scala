package net.medvekoma.imagedownloader

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

trait BatchFileWriter {
  this: AsyncFileWriter with FilenameProvider =>

  def writeFiles(urls: Set[String], targetFolder: String): Unit = {
    val futures = urls.map(url =>
      write(url, getFileName(url, targetFolder)))
    Await.result(Future.sequence(futures), 5.seconds)
    println("Done")
  }
}
