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
    public User user;
    
    @ManyToOne
    public Product product;
    
    @ManyToOne
    public MealTime mealTime;
    
	@Required
    public int mealWeight;
    
    @Required
    public String mealtimeID;
    
    @Required
    String date;
    
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
