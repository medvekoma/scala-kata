package net.medvekoma.imagedownloader

import scala.io.Source

trait PageReader {
  this: TextParser =>

  def getImageUrlsInPage(pageUrl: String): Set[String] = {
    val source = Source.fromURL(pageUrl)
    val html = source.mkString
    source.close()
    getImageUrls(html)
  }
}
