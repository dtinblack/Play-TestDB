package models

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.ValidBSONType.BasicDBList

import com.novus.salat._
import com.novus.salat.global._
import com.novus.salat.annotations._
import com.novus.salat.dao._

import com.novus.salat.{TypeHintFrequency, StringTypeHintStrategy, Context}
import play.api.Play
import play.api.Play.current

/* Adding a custom Salat context to work with Play's Classloader */

package object mongoContext {
  implicit val context = {
    val context = new Context {
      val name = "global"
      override val typeHintStrategy = StringTypeHintStrategy(when = TypeHintFrequency.WhenNecessary, typeHint = "_t")
    }
    context.registerGlobalKeyOverride(remapThis = "id", toThisInstead = "_id")
    context.registerClassLoader(Play.classloader)
    context
  }
}
import mongoContext._


/*
case class Quote (text: String, author: String)

object Quote{
    
 val quotes = MongoConnection()("TestDB")("quotes")
 
 def findAll = quotes.map(grater[Quote].asObject(_)).toList
 
 def add(quote: Quote) {
   
   quotes +=grater[Quote].asDBObject(quote)
   
// TODO Check if a quote already exists 
      
 }
   
}

*/

case class Quote(text: String, author: String)

object QuoteDAO extends SalatDAO[Quote, String] ( collection = MongoConnection()("TestDB")("quotes")) {
  
 
 /* 
  def findAll = QuoteDAO.find(ref = MongoDBObject("_id" -> MongoDBObject("$gte" -> -1)))
      .sort(orderBy = MongoDBObject("_id" -> -1)) // sort by _id desc
      .skip(1)
      .limit(1)
      .toList
*/
  
  def findAll = QuoteDAO.find(ref = MongoDBObject()).toList
  
  
  def add (quote: Quote ) { 
    
                QuoteDAO.insert(quote)
    
    // TODO
    
  }
  
}




