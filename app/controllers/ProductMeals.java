package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

import java.util.*;
import java.text.SimpleDateFormat;


public class ProductMeals extends Controller {

    final static Form<ProductMeal> productMealForm = form(ProductMeal.class);
    
    public static Result index(String date) {
        return ok(
            meals.render(productMealForm, ProductMeal.all(), date)
            );
    }
    
    @Security.Authenticated
    public static Result showAddForm(String date) {
        return ok(
            newMeal.render(productMealForm, Product.all(), date)
            );
    }
    
    public static Result add() {
        Form<ProductMeal> fromRequest = productMealForm.bindFromRequest();
        
        User user = User.validUsername(session("username"));
        Product product = Product.getProductByName(fromRequest.field("product").valueOr(""));
        int mealTime = (fromRequest.field("mealTime").valueOr("").isEmpty()) ? 0 : Integer.parseInt(fromRequest.field("mealTime").valueOr(""));
        int mealWeight = (fromRequest.field("mealWeight").valueOr("").isEmpty()) ? 0 : Integer.parseInt(fromRequest.field("mealWeight").valueOr(""));
        String date = (fromRequest.field("d").valueOr("").isEmpty()) ? MealTime.getDate(): fromRequest.field("d").valueOr("");

        if(user == null) {
            flash("fail", "You should log in first.");
            return badRequest(newMeal.render(fromRequest, Product.all(), date));
        }

        if(!(mealTime > 0 && mealTime <= 5)) {
            flash("fail", "Invalid Meal Time.");
            return badRequest(newMeal.render(fromRequest, Product.all(), date));
        } 

        if(!(mealWeight > 0)) {
            flash("fail", "Invalid Quantity.");
            return badRequest(newMeal.render(fromRequest, Product.all(), date));
        }

        if(product == null) {
            flash("fail", "Invalid product name.");
            return badRequest(newMeal.render(fromRequest, Product.all(), date));            
        }

        ProductMeal pm = new ProductMeal(
            session("username"),
            product.name,
            mealTime,
            mealWeight,
            date
        );

        ProductMeal.create(pm);
        flash("success", "Meal has been added succesfully.");
        return redirect(
            routes.ProductMeals.index(date)
        );

    }


}
