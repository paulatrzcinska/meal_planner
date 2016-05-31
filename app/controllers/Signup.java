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
                flash("fail", "Passwords don't match.");
                return badRequest(signup.render(filledForm));
            }
        }
        
        // check if the username is valid
        if(!filledForm.hasErrors()) {
            if(User.validUsername(filledForm.field("username").value()) != null) {
                flash("fail", "Username is already taken.");
                return badRequest(signup.render(filledForm));
            }
        }
        
        if(filledForm.hasErrors()) {
            flash("fail", "Something is wrong.");
            return badRequest(signup.render(filledForm));
        } else {
            User.createAccount(filledForm.get());
            return ok(summary.render(filledForm.get()));
        }
       
    }

}