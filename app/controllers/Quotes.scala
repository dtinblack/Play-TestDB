package controllers

import play.api.mvc.{Action, Controller}
import models.Quote

import play.api.data.Form
import play.api.data.Forms.{mapping, longNumber, nonEmptyText}
import play.api.i18n.Messages

import play.api.mvc.Flash

object Quotes extends Controller {
  
  private val quoteForm: Form[Quote] = Form(
      mapping(
        "id" -> longNumber,
         "text" -> nonEmptyText,
         "author" -> nonEmptyText
         ) (Quote.apply)(Quote.unapply)   
   )
  
  
  def list = Action { implicit request => 
     val quotes = Quote.findAll
     Ok(views.html.quotes.list(quotes))
  }
    

  
  def newQuote = Action { implicit request =>
   
     val form = if (flash.get("error").isDefined)
          quoteForm.bind(flash.data)
     else
          quoteForm

       
       Ok(views.html.quotes.editQuote(form))
         
  }
  
}