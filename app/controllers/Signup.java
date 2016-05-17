package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class Signup extends Controller {

    final static Form<User> signupForm = form(User.class);
    
    public static Result index() {
        return ok(
            signup.render(signupForm)
        );
    }
    
    public static Result submit() {
        Form<User> filledForm = signupForm.bindFromRequest();
        
        // check repeated password
        if(!filledForm.field("password").valueOr("").isEmpty()) {
            if(!filledForm.field("password").valueOr("").equals(filledForm.field("repeatPassword").value())) {
                filledForm.reject("repeatPassword", "Password don't match");
            }
        }
        
        // check if the username is valid
        // sprawdzenie czy uzytkownik juz istnieje xD
        
        if(filledForm.hasErrors()) {
            return badRequest(signup.render(filledForm));
        } else {
            User created = filledForm.get();
            return ok(summary.render(created));
        }
    }

}