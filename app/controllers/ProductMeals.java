package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class ProductMeals extends Controller {

    final static Form<ProductMeal> productMealForm = form(ProductMeal.class);
    
    public static Result index() {
        return TODO;
    }
    
    @Security.Authenticated
    public static Result showAddForm() {
        return ok(
            newMeal.render(productMealForm, Product.all())
            );
    }
    
    public static Result add() {
       return TODO;
    }

}
