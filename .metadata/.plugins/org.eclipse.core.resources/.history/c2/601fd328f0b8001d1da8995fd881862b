package com.hm.books.authservice.model;




import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "newUserLogin")
@AllArgsConstructor
@NoArgsConstructor

public class User {
	
	@Transient
	public static final String SEQUENCE_NAME = "newRegUsers_sequence";
	
	@Id
	private long userId;
	@Indexed(unique = true)
	private String username;
	private String email;
	private String password;
	private String confirmPassword;
}
