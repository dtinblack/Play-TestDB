package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("The application and developmemnt environment is ready to go."))
  }

}