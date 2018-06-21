package net.medvekoma.imagedownloader

import scalaz.Reader

trait Config {
  def asyncFileWriter: AsyncFileWriter
  def batchFileWriter: BatchFileWriter
  def filenameProvider: FilenameProvider
  def pageReader: PageReader
  def imageDownloader: ImageDownloader
  def textParser: TextParser
}

object ConfigRunner {
  def run[T](reader: Reader[Config, T], config: Config): T = {
    reader(config)
  }
}
