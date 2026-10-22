package ru.aston.homework.builder;

record UserProfile(
     String username,
     String phoneNumber,
     short age,
     String email
) {
    
    public static class Builder {
	private String username;
	private String phoneNumber;
	private short age = -1;
	private String email;

	public Builder username(String username) {
	    this.username = username;
	    return this;
	}

	public Builder phoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	    return this;
	}

	public Builder age(short age) {
	    this.age = age;
	    return this;
	}

	public Builder email(String email) {
	    this.email = email;
	    return this;
	}

	public UserProfile build() {
	    return new UserProfile(this.username, this.phoneNumber, this.age, this.email);
	}
    }
    
    @Override
    public String toString() {
	return String.format(
	    "Profile:\n username -> %s;\n age -> %s;\n email -> %s;\n phoneNumber -> %s",
	    (username == null || username.isBlank()) ? "undefined" : username,
	    age == -1 ? "undefined" : age,
	    (email == null || email.isBlank()) ? "undefined" : email,
	    (phoneNumber == null || phoneNumber.isBlank()) ? "undefined" : phoneNumber
	);
    }
}

		   
		   
		   
