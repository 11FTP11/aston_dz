package ru.aston.homework;

import ru.aston.homework.models.Student;
import ru.aston.homework.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import java.time.LocalDate;
import java.util.Comparator;
import java.io.FileNotFoundException;

public class App 
{
	public static final String FILENAME = "students.json";
	public static final LocalDate THRESHOLD_DATE = LocalDate.parse("2000-01-01");
	public static final int BOOKS_LIMIT = 3;

    public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		File json = new File(FILENAME);

		try {

			List<Student> students = mapper.readValue(json, new TypeReference<List<Student>>() {});
			students.stream()
				.peek(System.out::println)
				.flatMap(student -> student.books().stream())
				.sorted(Comparator.comparingInt(Book::pageCount))
				.distinct()
				.filter((Book book) -> book.publishedDate().isAfter(THRESHOLD_DATE))
				.limit(BOOKS_LIMIT)
				.map(book -> book.publishedDate().getYear())
				.findAny()
				.ifPresentOrElse(
					(year) -> System.out.printf("Found book with date %s\n", year),
					() -> System.out.println("Books were not found")
				);

		} catch (FileNotFoundException e) {
			System.err.printf("File \"%s\" not found\n", FILENAME);
		} catch (IOException e) {
			System.err.printf("Error occurred while reading \"%s\": %s\n", FILENAME, e.getMessage());
		}
	}
}
