package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class Product extends Model {

    @Id
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
    
}
