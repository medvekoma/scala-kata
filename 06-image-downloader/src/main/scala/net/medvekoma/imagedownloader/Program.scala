package net.medvekoma.imagedownloader

object Program extends App {

  private val settings = SettingsProvider.getSettings(args)
  ImageDownloader.download(settings.sourceUrl, settings.targetFolder)
}
