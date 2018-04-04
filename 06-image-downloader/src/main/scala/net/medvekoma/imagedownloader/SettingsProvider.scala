package net.medvekoma.imagedownloader

trait SettingsProvider {

  def getSettings(args: Array[String]): Settings = {
    Settings(
      sourceUrl = "http://portfotolio.net/markusbinzegger",
      targetFolder = "./target"
    )
  }

}
