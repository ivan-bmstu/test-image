package ru.hh.school.projects.wordstat.trymakeimage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.hh.school.projects.wordstat.trymakeimage.models.Product;
import ru.hh.school.projects.wordstat.trymakeimage.repositories.ProductRepository;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TryMakeImageApplicationTests {

	@LocalServerPort
	private Integer port;

	static PostgreSQLContainer<?> postgres =
			new PostgreSQLContainer<>("postgres:15-alpine");

	@BeforeAll
	static void beforeAll() {
		postgres.start();
	}

	@AfterAll
	static void afterAll() {
		postgres.stop();
	}

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgres::getJdbcUrl);
		registry.add("spring.datasource.username", postgres::getUsername);
		registry.add("spring.datasource.password", postgres::getPassword);
	}

	@Autowired
	ProductRepository productRepository;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost:" + port;
		productRepository.deleteAll();
	}

	@Test
	void shouldGetAllProducts() {
		List<Product> products = List.of(
				new Product(null,"Beer"),
				new Product(null, "Fish"),
				new Product(null, "Meat")
		);
		var productsReturn = productRepository.saveAll(products);

		productsReturn.forEach(this::restAssert);
	}

	private void restAssert(Product product) {
		given()
				.contentType(ContentType.JSON)
				.when()
				.get("/product/" + product.getId())
				.then()
				.statusCode(200)
				.body("title", is(product.getTitle()));
	}

}
