package net.medvekoma.imagedownloader

object SettingsProvider {

  def getSettings(args: Array[String]): Settings = {
    Settings(
      sourceUrl = "http://portfotolio.net/markusbinzegger",
      targetFolder = "./target"
    )
  }

}
