package net.srirangan.simplewebcrawler.app

import java.lang.String
import org.gridgain.grid._
import org.gridgain.scalar.scalar
import org.gridgain.scalar.scalar._
import net.srirangan.simplewebcrawler.tasks.LoadUrlTask

object Main {

  def main(args: Array[String]):Unit = {
    scalar {
      val baseUrl:String = "http://base.url.to.begin.crawling?level=1"
      grid.execute(classOf[LoadUrlTask], baseUrl).get
    }
  }
  
}
