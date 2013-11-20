package models

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.ValidBSONType.BasicDBList
import com.novus.salat._
import com.novus.salat.global._
import com.mongodb.casbah.Imports._
import com.novus.salat.annotations._

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

case class Quote (text: String, author: String)

object Quote{
    
 val quotes = MongoConnection()("TestDB")("quotes")
 
 def findAll = quotes.map(grater[Quote].asObject(_)).toList
 
 def add(quote: Quote) {
   
   quotes +=grater[Quote].asDBObject(quote)
   
 } 
  
  
  
  /*
  
  var quotes = Set (
      
   Quote("The world is everything",
    "Ludwig Wittgenstien"),
   Quote("Tomorrow is another day",
    "Scarlet O'Hara"),
   Quote("It never rains but it pours", "Annonymous")
     
  )
  
 def findAll = quotes.toList.sortBy(_.text)
 
 def checkQuote( quote: Quote ) = quotes.contains(quote)
 
 def add( quote: Quote ) {
   
      quotes = quotes + quote
   }
 
 def howMany = quotes.size
 * 
 * 
 */
   
}



