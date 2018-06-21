package net.medvekoma.imagedownloader

trait TextParser {

  def getImageUrls(html: String): Set[String] = {
    val imagePattern = """https?:\/\/.*\.jpg""".r
    imagePattern.findAllIn(html).toSet
  }

}
