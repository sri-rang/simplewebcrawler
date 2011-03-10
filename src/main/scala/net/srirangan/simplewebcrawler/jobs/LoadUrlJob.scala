package net.srirangan.simplewebcrawler.jobs

import java.lang.String
import java.util.{List,ArrayList}
import org.gridgain.grid.GridJobAdapterEx
import org.gridgain.scalar.scalar._
import net.srirangan.simplewebcrawler.tasks.{LoadUrlTask,IndexKeywordsTask}

class LoadUrlJob(url:String) extends GridJobAdapterEx {
  def execute():Object = {
    println("load url for - " + url)

    val data:String = "this is data for " + url
    val urls:List[String] = new ArrayList[String]()

    //
    // .. actual parser logic comes here
    // .. data:String will contain the contents of url:String
    // .. urls:List is a list of all new URLs found in data:String
    //
    
    // Start indexing keywords for data:String from url:String
    grid.execute(classOf[IndexKeywordsTask], data).get
    
    // adding dummy url in urls:List
    urls.add(url + ".1")

    // start load url for urls:List
    while( urls.iterator.hasNext() ) {
      val url:String = urls.iterator.next()
      grid.execute(classOf[LoadUrlTask], url).get
    }
    

    data
  }
}
