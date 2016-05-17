package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Product extends Model {

    @Id
    public int id;
    
    @Required
    public String name;
    @Required
	public int caloriesPer100Grams;
	@Required
	public int carbPer100Grams;
	@Required
	public int fatPer100Grams;
	@Required
	public int proteinPer100Grams;
	@Required
	public int sugarPer100Grams;
    
    public static Finder<Long,Product> find = new Finder(
        Long.class, Product.class
    );
    
    public static List<Product> all() {
        return find.all();
    }
    
    public static void create(Product product) {
        product.save();
    }
    
}
