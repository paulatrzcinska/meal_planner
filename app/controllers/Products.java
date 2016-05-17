package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class Products extends Controller {

    final static Form<Product> productForm = form(Product.class);
    
    public static Result index() {
        return ok(
            products.render(Product.all(), productForm)
        );
    }
    
    public static Result showAddForm() {
        return ok(
            newProduct.render(productForm)
        );
    }
    
    public static Result add() {
        Form<Product> filledForm = productForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            return badRequest(newProduct.render(filledForm));
        } else {
            Product.create(filledForm.get());
            return redirect(routes.Products.index());
        }
    }

}
