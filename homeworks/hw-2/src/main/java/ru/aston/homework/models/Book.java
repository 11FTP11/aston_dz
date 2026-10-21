package ru.aston.homework.models;

import com.fasterxml.jackson.annotation.JsonProperty; 
import java.time.LocalDate;
import java.util.Objects;

public record Book (
		@JsonProperty(required = true) String name,
		@JsonProperty(required = true) String author,
		@JsonProperty(required = true, value = "published_date") LocalDate publishedDate,
		@JsonProperty(required = true, value = "page_count") int pageCount
	) {
		public Book {
			Objects.requireNonNull(name, "field \"name\" cannot be null");
			Objects.requireNonNull(author, "field \"author\" cannot be null");
			Objects.requireNonNull(publishedDate, "field \"published_date\" cannot be null");
		}
	} 
