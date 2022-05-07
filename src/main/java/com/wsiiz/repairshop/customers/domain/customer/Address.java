package com.wsiiz.repairshop.customers.domain.customer;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  String locality;
  String street;
  String apartmentNo;
  String postalCode;
}
