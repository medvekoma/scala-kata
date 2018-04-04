package net.medvekoma.imagedownloader

import com.softwaremill.macwire._

object Module {
  lazy val asyncFileWriter = wire[AsyncFileWriter]
  lazy val batchFileWriter = wire[BatchFileWriter]
  lazy val filenameProvider = wire[FilenameProvider]
  lazy val pageReader = wire[PageReader]
  lazy val textParser = wire[TextParser]

  lazy val imageDownloader = wire[ImageDownloader]
  lazy val settingsProvider = wire[SettingsProvider]
}
