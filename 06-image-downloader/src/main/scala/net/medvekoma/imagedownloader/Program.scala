package net.medvekoma.imagedownloader

object Program extends App {

  object Module extends
    AsyncFileWriter with BatchFileWriter with FilenameProvider
    with ImageDownloader with PageReader with SettingsProvider with TextParser {}

  private val settings = Module.getSettings(args)
  Module.download(settings.sourceUrl, settings.targetFolder)
}
