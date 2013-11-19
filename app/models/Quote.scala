package models

case class Quote (text: String, author: String)

object Quote{
  
  
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
   
}



