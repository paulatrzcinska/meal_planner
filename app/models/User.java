package models;

import javax.validation.*;
import play.data.validation.Constraints.*;

public class User {

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

	@Valid
	public UserDetails userDetails;

	public User() {}

	public User(String username, String email, String password, UserDetails userDetails) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.userDetails = userDetails;
	}


	public static class UserDetails {

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

		public UserDetails() {}

		public UserDetails(String name, String surname, boolean gender, int weight, int height, int age) {
			this.name = name;
			this.surname = surname;
			this.gender = gender;
			this.weight = weight;
			this.height = height;
			this.age = age;
		}

	}

}