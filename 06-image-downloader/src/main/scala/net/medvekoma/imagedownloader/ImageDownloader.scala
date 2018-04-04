package net.medvekoma.imagedownloader

trait ImageDownloader {
  this: PageReader with BatchFileWriter =>

  def download(sourceUrl: String, targetFolder: String): Unit = {
    val imageUrls = getImageUrlsInPage(sourceUrl)
    writeFiles(imageUrls, targetFolder)
  }
}
