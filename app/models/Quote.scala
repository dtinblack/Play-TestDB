package models

case class Quote (id: Long, text: String, author: String)

object Quote{
  
  
 var quotes = Set (
      
   Quote(1, "The world is everything",
    "Ludwig Wittgenstien"),
   Quote(2, "Tomorrow is another day",
    "Scarlet O'Hara"),
   Quote(3, "It never rains but it pours", "Annonymous")
     
  )
  
 def findAll = quotes.toList.sortBy(_.id)
 
 def findById( id: Long) = quotes.find(_.id == id)
 
 def add( quote: Quote ) {
   
      quotes = quotes + quote
   }
   
}



