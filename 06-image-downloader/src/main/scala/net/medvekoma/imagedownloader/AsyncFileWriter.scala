package net.medvekoma.imagedownloader

import sys.process._
import java.net.URL
import java.io.File

import scala.concurrent.Future
import scala.language.postfixOps
import scala.concurrent.ExecutionContext.Implicits.global

class AsyncFileWriter {

  def write(sourceUrl: String, targetFile: String): Future[Unit] = {
    println(s"Saving $targetFile...")
    Future(new URL(sourceUrl) #> new File(targetFile) !!)
  }

}
