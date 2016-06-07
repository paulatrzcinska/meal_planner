package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class ProductMeal extends Model {

    @Id
    public Long id;
    
    @ManyToOne
    public User owner;
    
    //@OneToMany(mappedBy = "productMeal")
	//public List<Product> products = new ArrayList<>();
    
    @ManyToOne
    public Product product;
    
    //@ManyToOne
    //public MealTime mealTime;
    
	@Required
    public int mealWeight;
    
    @Required
    String date;
    
    public ProductMeal(User owner, Product product, int mealWeight, String date){
        this.owner = owner;
        this.product = product;
        this.mealWeight = mealWeight;
        this.date = date;
    }
    
    public static Finder<Long,ProductMeal> find = new Finder(
        Long.class, ProductMeal.class
    );
    
    public static List<ProductMeal> all() {
        return find.all();
    }
    
    public static void create(ProductMeal productMeal) {
        productMeal.save();
    }
    
}
