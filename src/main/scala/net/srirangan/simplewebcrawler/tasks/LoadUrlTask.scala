package net.srirangan.simplewebcrawler.tasks

import java.lang.String
import java.util.{List,ArrayList}
import org.gridgain.grid._
import net.srirangan.simplewebcrawler.jobs.LoadUrlJob

class LoadUrlTask extends GridTaskNoReduceSplitAdapter[String] {

  def split(gridSize:Int, url:String):List[GridJob] = {
    val jobs:List[GridJob] = new ArrayList[GridJob]()
    val job:GridJob = new LoadUrlJob(url)
    jobs.add(job)
    jobs
  }
  
}
