package com.security.lesson.security.service;

import com.security.lesson.security.model.entity.Person;
import com.security.lesson.security.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService {
  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person create(Person person) {
    String hashedPassword = new BCryptPasswordEncoder()
        .encode(person.getPassword());

    person.setPassword(hashedPassword);
    return personRepository.save(person);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return personRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
  }
}
