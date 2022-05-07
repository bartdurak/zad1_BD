package com.wsiiz.repairshop.customers.domain.customer;

import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("PERSON")
public class Person extends Customer {

  String name;
  String surname;
  LocalDate birthDate;
  String pesel;

  @Enumerated(value = EnumType.STRING)
  Sex sex;

  @Override
  public String fullName() {
    return name + " " + surname;
  }
}
