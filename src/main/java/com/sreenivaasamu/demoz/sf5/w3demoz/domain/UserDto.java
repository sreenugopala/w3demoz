package com.sreenivaasamu.demoz.sf5.w3demoz.domain;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.sreenivaasamu.demoz.sf5.w3demoz.domain.validation.PasswordMatches;
import com.sreenivaasamu.demoz.sf5.w3demoz.domain.validation.ValidEmail;

import lombok.Data;

@Data
@PasswordMatches
public class UserDto {
	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;
}