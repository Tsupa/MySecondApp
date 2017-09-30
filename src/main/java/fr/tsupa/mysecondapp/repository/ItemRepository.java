package fr.tsupa.mysecondapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.tsupa.mysecondapp.domain.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

	List<Item> findAllByActive(boolean active);

	Optional<Item> findOneById(String id);

	Optional<Item> findOneByName(String name);
}
