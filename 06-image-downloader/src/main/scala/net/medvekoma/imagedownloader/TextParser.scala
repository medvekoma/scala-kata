package net.medvekoma.imagedownloader

class TextParser {

  def getImageUrls(html: String): Set[String] = {
    val imagePattern = """https?:\/\/.*\.jpg""".r
    imagePattern.findAllIn(html).toSet
  }

}
