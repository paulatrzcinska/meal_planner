package models;

import java.util.*;

import javax.validation.*;
import play.data.validation.Constraints.*;
import play.db.ebean.*;
import javax.persistence.*;

@Entity
public class User extends Model {

	@Id
	public int id;

	@Required
	@MinLength(value = 4)
	@MaxLength(value = 25)
	public String username;

	@Required
	@Email
	public String email;

	@Required
	@MinLength(value = 6)
	public String password;

	@MinLength(value = 2)
	public String name;

	@MinLength(value = 2)
	public String surname;

	@Required
	public boolean gender;

	public int weight;
	public int height;

	@Min(value = 10)
	@Max(value = 100)
	public int age;

	public User() {}

	public User(String username, String email, String password, String name, String surname, boolean gender, int weight, int height, int age) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.age = age;
	}
	
	public static Finder<Long,User> find = new Finder(Long.class, User.class);
	
	public static User validUsername(String username) {
		return find.where().eq("username", username).findUnique();
	}
	
	public static void createAccount(User account) {
		account.save();
	}

}