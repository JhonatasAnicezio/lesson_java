package com.security.lesson.security.model.repository;

import com.security.lesson.security.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  Optional<Person> findByUsername(String username);
}
