package com.wsiiz.repairshop.enterprise.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    String apartment;
    String locality;
    String postCode;
}
