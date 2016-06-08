package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class ProductMeal extends Model {

    @Id
    public Long id;
    
    @Required
    public String user;
    
    @Required
	public String product;
    
    @Required
    public int mealTime;
    
	@Required
    public int mealWeight;

    @Required
    public String date;

    public ProductMeal(String user, String product, int mealTime, int mealWeight, String date) {
        this.user = user;
        this.product = product;
        this.mealTime = mealTime;
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

    public static int[] getSummary(int mealTime, String date) {
        int calories=0;
        int carb=0;
        int fat=0;
        int protein=0;
        int sugar=0;

        List<ProductMeal> meals = ProductMeal.find.where().eq("mealTime", mealTime).eq("date", date).findList();
        for(ProductMeal pm : meals) {
            calories += (Product.getProductByName(pm.product).caloriesPer100Grams * pm.mealWeight);
            carb += (Product.getProductByName(pm.product).carbPer100Grams * pm.mealWeight);
            fat += (Product.getProductByName(pm.product).fatPer100Grams * pm.mealWeight);
            protein += (Product.getProductByName(pm.product).proteinPer100Grams * pm.mealWeight);
            sugar += (Product.getProductByName(pm.product).sugarPer100Grams * pm.mealWeight);
        }
        int[] A = {calories, carb, fat, protein, sugar};
        return A;
    }

    public static boolean isEmptyMT(int mealTime, String date, String user) {
        List<ProductMeal> meals = ProductMeal.find.where().eq("mealTime", mealTime).eq("date", date).eq("user", user).findList();
        if(meals.size() == 0) return true;
        else return false;
    }


    public static String getMealTimeName(int mealTime) {
        if(mealTime == 1) return "Breakfast";
        if(mealTime == 2) return "Brunch";
        if(mealTime == 3) return "Dinner";
        if(mealTime == 4) return "Tea";
        return "Supper";
    }


}
