package controllers

import play.api.mvc.{Action, Controller}
import models.Quote

object Quotes extends Controller {
  
  def list = Action { implicit request => 
    
    val quotes = Quote.findAll
    
    Ok(views.html.quotes.list(quotes))
  
  }
  
  

}