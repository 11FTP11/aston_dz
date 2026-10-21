package ru.aston.homework.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.Objects;

public record Student(
		@JsonProperty(required = true, value = "student_id") String id, 
		@JsonProperty(required = true, value = "first_name") String firstName, 
		@JsonProperty(required = true, value = "last_name") String lastName, 
		@JsonProperty(required = true) short age, 
		@JsonProperty(required = true) Contact contact,
		@JsonProperty(required = true) List<Book> books
	) {

		public Student {
			Objects.requireNonNull(id, "field \"student_id\" cannot be null");
			Objects.requireNonNull(firstName, "field \"first_name\" cannot be null");
			Objects.requireNonNull(lastName, "field \"last_name\" cannot be null");
			Objects.requireNonNull(contact, "field \"contact\" cannot be null");
			Objects.requireNonNull(books, "field \"books\" cannot be null");
		}
		
		@Override
		public String toString() {
			return String.format("Student %s %s (ID: %s, age: %d):\n - email: %s;\n - phone: %s.", 
            firstName, lastName, id, age, contact.email(), contact.phone());
		}
	}

