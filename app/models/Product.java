package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.*;

import play.data.format.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;

import com.avaje.ebean.*;

@Entity
public class Product extends Model {

    @Id
    public Long id;
    
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
    
    @ManyToOne
    public ProductMeal productMeal;
    
    public static Finder<Long,Product> find = new Finder(Long.class, Product.class);
    
    public static List<Product> all() {
        return find.all();
    }

    public static Page<Product> page(int page, int pageSize, String sortBy, String order, String filter) {
	    return find.where()
		    .ilike("name", "%" + filter + "%")
		    .orderBy(sortBy + " " + order)
		    .findPagingList(pageSize)
		    .setFetchAhead(false)
		    .getPage(page);
    }

    public static void create(Product product) {
        product.save();
    }
    
}
