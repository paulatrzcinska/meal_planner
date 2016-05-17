package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class Login extends Controller {

    final static Form<User> loginForm = form(User.class);
    
    public static Result index() {
        return ok(
            login.render(loginForm)
        );
    }
    
    public static Result submit() {
        return TODO;
    }

}
