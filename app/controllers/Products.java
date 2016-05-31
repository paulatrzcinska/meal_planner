package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

import models.*;

public class Products extends Controller {

    final static Form<Product> productForm = form(Product.class);
    
    
    public static Result index() {
        return redirect(routes.Products.products(0, "name", "asc", ""));
    }

    public static Result products(int page, String sortBy, String order, String filter) {
	return ok(
		products.render(
			Product.page(page, 10, sortBy, order, filter),
			sortBy, order, filter
		)
	);
    }
    
    @Security.Authenticated
    public static Result showAddForm() {
        return ok(
            newProduct.render(productForm)
        );
    }
    
    public static Result add() {
        Form<Product> filledForm = productForm.bindFromRequest();
        if(filledForm.hasErrors()) {
            flash("fail", "Invalid product name.");
            return badRequest(newProduct.render(filledForm));
        } else {
            Product.create(filledForm.get());
            flash("success", "Product has been added succesfully.");
            return redirect(routes.Products.products(0, "name", "asc", ""));
        }
    }

}
