package net.medvekoma.imagedownloader

object Program extends App {

  private val settings = SettingsProvider.getSettings(args)

  val config = new Config {
    override def asyncFileWriter: AsyncFileWriter = new AsyncFileWriter {}
    override def batchFileWriter: BatchFileWriter = new BatchFileWriter {}
    override def filenameProvider: FilenameProvider = new FilenameProvider {}
    override def pageReader: PageReader = new PageReader {}
    override def imageDownloader: ImageDownloader = new ImageDownloader {}
    override def textParser: TextParser = new TextParser {}
  }
  val reader = config.imageDownloader.download(settings.sourceUrl, settings.targetFolder)
  reader.apply(config)
//  reader.run(config)
}
