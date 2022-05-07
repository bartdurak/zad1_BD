package com.wsiiz.repairshop.customers.domain.customer;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class Customer extends BaseEntity {

  @AttributeOverrides({
      @AttributeOverride(name = "locality", column = @Column(name = "HOME_LOCALITY")),
      @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
      @AttributeOverride(name = "apartmentNo", column = @Column(name = "HOME_APARTMENT_NO")),
      @AttributeOverride(name = "postalCode", column = @Column(name = "HOME_POSTAL_CODE"))
  })
  Address homeAddress;

  @AttributeOverrides({
      @AttributeOverride(name = "locality", column = @Column(name = "CORRESPONDENCE_LOCALITY")),
      @AttributeOverride(name = "street", column = @Column(name = "CORRESPONDENCE_STREET")),
      @AttributeOverride(name = "apartmentNo", column = @Column(name = "CORRESPONDENCE_APARTMENT_NO")),
      @AttributeOverride(name = "postalCode", column = @Column(name = "CORRESPONDENCE_POSTAL_CODE"))
  })
  Address correspondenceAddress;

  public abstract String fullName();
}
