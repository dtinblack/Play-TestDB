package controllers

import play.api.mvc.{Action, Controller}
import models._

import play.api.data.Form
import play.api.data.Forms.{mapping, number, nonEmptyText}
import play.api.i18n.Messages

import play.api.mvc.Flash

object Quotes extends Controller {
    
  private val quoteForm: Form[Quote] = Form(
      mapping(
         "text" -> nonEmptyText,
         "author" -> nonEmptyText
         ) (Quote.apply)(Quote.unapply)   
   )
  
  
  def list = Action { implicit request => 
     val quotes = QuoteDAO.findAll
     Ok(views.html.quotes.list(quotes))
  }
    
  
  def newQuote = Action { implicit request =>
   
     val form = if (flash.get("error").isDefined)
          quoteForm.bind(flash.data)
     else
          quoteForm

      Ok(views.html.quotes.addQuote(form))
         
  }
  
  def save = Action{ implicit request => 
      val newQuoteForm = quoteForm.bindFromRequest()
            
      newQuoteForm.fold( 
        
      /* if validation fails, redirect back to Add Page */  
          
      hasErrors = { form => 
            Redirect(routes.Quotes.newQuote()) .
            flashing(Flash(form.data) +
               ("error" -> Messages("validation.errors"))    
            )            
      },
              
      /* if validation a success then save and redirect back to the List Page */
            
      success = { newQuote =>
                
        if(QuoteDAO.checkQuote(newQuote))
         {
         /* database contains the quote */
         val message = Messages("quotes.new.failure")
         Redirect(routes.Quotes.newQuote()) .
           flashing("error" -> message)

         }     
        else
        {
         /* database doesn't contain the quote */
         
        QuoteDAO.add(newQuote)
        val message = Messages("quotes.new.success")
        Redirect(routes.Quotes.list()) .
        flashing("success" -> message)
       
        }

       }    
            
      )  
  }
    
}