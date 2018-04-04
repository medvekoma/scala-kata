package net.medvekoma.imagedownloader

class ImageDownloader(pageReader: PageReader, batchFileWriter: BatchFileWriter) {

  def download(sourceUrl: String, targetFolder: String): Unit = {
    val imageUrls = pageReader.getImageUrls(sourceUrl)
    batchFileWriter.writeFiles(imageUrls, targetFolder)
  }
}
