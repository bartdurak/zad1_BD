package com.wsiiz.repairshop.customers.application;

import com.wsiiz.repairshop.customers.domain.customer.Customer;
import com.wsiiz.repairshop.customers.domain.customer.Person;
import com.wsiiz.repairshop.customers.domain.customer.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  @Autowired
  PersonRepository personRepository;

  @GetMapping("/customers/persons")
  public ResponseEntity<List<Person>> getMany(
      @RequestParam(value = "pesel", required = false) String pesel,
      @RequestParam(value = "name", required = false) String name,
      @RequestParam(value = "surname", required = false) String surname) {
    return ResponseEntity.ok(personRepository.findByCriteria(pesel, name, surname));
  }

  @GetMapping("/customers/persons/{id}")
  public ResponseEntity<Person> getOne(@PathVariable("id") Long id) {

    Optional<Person> service = personRepository.findById(id);

    if (service.isPresent()) {
      return ResponseEntity.ok(service.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/customers/persons")
  public ResponseEntity<Customer> addNew(@RequestBody Person customer) {
    return ResponseEntity.created(null).body(personRepository.save(customer));
  }

  @DeleteMapping("/customers/persons/{id}")
  public ResponseEntity<Customer> remove(@PathVariable("id") Long id) {

    Optional<Person> customer = personRepository.findById(id);

    if (customer.isPresent()) {
      personRepository.deleteById(id);
      return ResponseEntity.ok(customer.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
