package net.srirangan.simplewebcrawler.jobs

import java.lang.String
import org.gridgain.grid.GridJobAdapterEx
import org.gridgain.scalar.scalar._

class IndexKeywordsJob(data:String) extends GridJobAdapterEx {
  def execute():Object = {
    println(data)
    // .. actual indexing logic comes here
    null
  }
}
