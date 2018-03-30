package net.medvekoma.imagedownloader

object TextParser {

  def getImageUrls(html: String): Set[String] = {
    val imagePattern = """https?:\/\/.*\.jpg""".r
    imagePattern.findAllIn(html).toSet
  }

}
