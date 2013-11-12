package models

case class Quote (id: Long, text: String, author: String)

object Quote {
  
  val quotes = Set (
    
    Quote(1L, "The World is everything", "Ludwig Wittgenstein"),
    Quote(2L, "Tomorrow is another day", "Scarlet O'Hara"),
    Quote(3L, "It never rains but it pours", "Annonymous")
       
  )
    
  def findAll = quotes.toList.sortBy(_.id)
}



