package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;


public class Login extends Controller {

    final static Form<LoginData> loginForm = form(LoginData.class);
    
    public static Result index() {
        return ok(
            login.render(new Form<Login>(Login.class))
        );
    }
    
    public static Result submit() {
        Form<LoginData> filledForm = loginForm.bindFromRequest();
        if(filledForm.hasErrors()) {
           flash("fail", "Invalid username or password.");
        } else {
            if(User.auth(filledForm.get().username, filledForm.get().password) != null) {
                session().clear();
                session("username", filledForm.get().username);
                //session("username_id", Integer.ToString(User.find.where().eq("username", "paula").findUnique().id));
                session("username_id", Integer.toString(User.validUsername(filledForm.get().username).id));
                session("logged", "true");
                flash("success", "Login successfully.");
            }
        }
        //return "NOP";
        return redirect(routes.Login.index());
    }
    
    public static Result logout() {
        session().clear();
        flash("success", "Logout successfully");
        return redirect(routes.Login.index());
    }
    
    public static class LoginData {
        public String username;
        public String password;
        
        public String validate() {
            if(User.auth(username, password) == null) {
                return "Invalid username or password";
            }
            return null;
        }
    }
    

}
