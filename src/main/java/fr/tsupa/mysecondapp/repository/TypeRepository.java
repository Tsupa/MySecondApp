package fr.tsupa.mysecondapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fr.tsupa.mysecondapp.domain.Type;

@Repository
public interface TypeRepository extends MongoRepository<Type, String> {

	List<Type> findAllByActive(boolean active);

	Optional<Type> findOneById(String id);

	Optional<Type> findOneByName(String name);
}
