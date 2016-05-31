package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class MealTime extends Model {

    @Id
    public Long id;
    
    @Required
    public String mealTimeName;
    
    @OneToMany(mappedBy = "mealTime")
	public List<ProductMeal> productMeals = new ArrayList<>();
}
