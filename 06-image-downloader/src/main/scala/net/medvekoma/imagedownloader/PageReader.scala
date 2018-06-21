package net.medvekoma.imagedownloader

import scalaz.Reader

import scala.io.Source

trait PageReader {

  def getImageUrls(pageUrl: String): Reader[Config, Set[String]] = Reader((config: Config) => {
    val source = Source.fromURL(pageUrl)
    val html = source.mkString
    source.close()
    config.textParser.getImageUrls(html)
  })
}
