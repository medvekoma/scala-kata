package net.medvekoma.imagedownloader

object Program extends App
    with AsyncFileWriter with BatchFileWriter with FilenameProvider
    with ImageDownloader with PageReader with SettingsProvider with TextParser {

  private val settings = getSettings(args)
  download(settings.sourceUrl, settings.targetFolder)
}
