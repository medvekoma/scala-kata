package net.medvekoma.imagedownloader

import scala.io.Source

object PageReader {

  def getImageUrls(pageUrl: String): Set[String] = {
    val source = Source.fromURL(pageUrl)
    val html = source.mkString
    source.close()
    TextParser.getImageUrls(html)
  }
}
