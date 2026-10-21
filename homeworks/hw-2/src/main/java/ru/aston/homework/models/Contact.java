package ru.aston.homework.models;

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.Objects;

public record Contact(
		@JsonProperty(required = true) String email, 
		@JsonProperty(required = true) String phone
	) {
		public Contact {
			Objects.requireNonNull(email, "field \"email\" cannot be null");
			Objects.requireNonNull(phone, "field \"phone\" cannot be null");
		}
	}
