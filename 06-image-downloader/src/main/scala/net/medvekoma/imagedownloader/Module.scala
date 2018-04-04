package net.medvekoma.imagedownloader

object Module {
  lazy implicit val asyncFileWriter = new AsyncFileWriter
  lazy implicit val filenameProvider = new FilenameProvider
  lazy implicit val batchFileWriter = new BatchFileWriter
  lazy implicit val textParser = new TextParser
  lazy implicit val pageReader = new PageReader

  lazy implicit val imageDownloader = new ImageDownloader
  lazy implicit val settingsProvider = new SettingsProvider
}
