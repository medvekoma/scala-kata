package net.medvekoma.imagedownloader

import scalaz.Reader

trait ImageDownloader {

  def download(sourceUrl: String, targetFolder: String) = Reader((config: Config) => {

    val value = config.pageReader.getImageUrls(sourceUrl)
      .flatMap(urls => config.batchFileWriter.writeFiles(urls, targetFolder))
    value
    // values.run(config)
  })

}
