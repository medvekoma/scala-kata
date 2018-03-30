package net.medvekoma.imagedownloader.utilities

import scala.util.{Failure, Success, Try}

object AutoClose {

  def apply[A <: AutoCloseable, B](resource: A)(block: A => B): B = {
    Try(block(resource)) match {
      case Success(result) =>
        resource.close()
        result
      case Failure(e) =>
        resource.close()
        throw e
    }
  }
}
