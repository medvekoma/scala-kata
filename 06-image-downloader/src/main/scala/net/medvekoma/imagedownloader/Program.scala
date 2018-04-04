package net.medvekoma.imagedownloader

object Program extends App {

  private val settings = Module.settingsProvider.getSettings(args)
  Module.imageDownloader.download(settings.sourceUrl, settings.targetFolder)
}
