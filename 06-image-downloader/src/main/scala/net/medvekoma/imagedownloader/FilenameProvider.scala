package net.medvekoma.imagedownloader

class FilenameProvider {

  def getFileName(sourceUrl: String, targetFolder: String): String = {
    val from = sourceUrl.lastIndexOf('/') + 1
    val fileName = sourceUrl.substring(from)
    if (targetFolder.isEmpty)
      fileName
    else
      targetFolder + '/' + fileName
  }
}
