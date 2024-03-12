package ru.hh.school.projects.wordstat.trymakeimage.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.hh.school.projects.wordstat.trymakeimage.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
