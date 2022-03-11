package com.wsiiz.repairshop.servicing.domain.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.servicing.domain.service.Employee;
import com.wsiiz.repairshop.servicing.domain.service.Service;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"service"})
public class Task extends BaseEntity {

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "service_id")
  @JsonIgnore
  Service service;

  String description;

  Employee responsiblePerson;

  public Task(Service service, String description) {
    this.service = service;
    this.description = description;
  }
}
