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
        "id" -> longNumber.verifying(
            "validation.id.duplicate", Quote.findById(_).isEmpty),
         "text" -> nonEmptyText,
         "author" -> nonEmptyText
         ) (Quote.apply)(Quote.unapply)   
   )
  
  
  def list = Action { implicit request => 
     val quotes = Quote.findAll
     Ok(views.html.quotes.list(quotes))
  }
  
    def show(id: Long) = Action { implicit request =>
    
    Quote.findById(id).map{ quote => 
      Ok(views.html.quotes.details(quote))
     }.getOrElse(NotFound)  
  }
  
  def save = Action { implicit request =>
    
     val newQuoteForm = quoteForm.bindFromRequest()
     
     newQuoteForm.fold(
         hasErrors = { form =>
           Redirect(routes.Quotes.newQuote()) .
            flashing(Flash(form.data) + 
                ("error" -> Messages("validation.errors")))   
         },
         
         success = { newQuote => 
           Quote.add(newQuote)
           val message = Messages("quotes.new.success", newQuote.text)
           Redirect(routes.Quotes.show(newQuote.id)) .
            flashing("success" -> message)                    
         }
      )   
  }
  
  def newQuote = Action { implicit request =>
   
     val form = if (flash.get("error").isDefined)
          quoteForm.bind(flash.data)
     else
          quoteForm

       
       Ok(views.html.quotes.editQuote(form))
         
  }
  
}