package com.wsiiz.repairshop.customers.domain.customer;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

  @Query(value = "select c from Person c where (:pesel = null or c.pesel = :pesel) "
      + "and (:name = null or c.name = :name) and (:surname = null or c.surname = :surname)")
  List<Person> findByCriteria(@Param("pesel") String pesel, @Param("name") String name,
      @Param("surname") String surname);

}
