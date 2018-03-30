package net.medvekoma.imagedownloader

object ImageDownloader {

  def download(sourceUrl: String, targetFolder: String): Unit = {
    val imageUrls = PageReader.getImageUrls(sourceUrl)
    BatchFileWriter.writeFiles(imageUrls, targetFolder)
  }
}
