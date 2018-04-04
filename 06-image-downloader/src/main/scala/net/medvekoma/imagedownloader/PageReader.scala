package net.medvekoma.imagedownloader

import scala.io.Source

class PageReader(implicit textParser: TextParser) {

  def getImageUrls(pageUrl: String): Set[String] = {
    val source = Source.fromURL(pageUrl)
    val html = source.mkString
    source.close()
    textParser.getImageUrls(html)
  }
}
