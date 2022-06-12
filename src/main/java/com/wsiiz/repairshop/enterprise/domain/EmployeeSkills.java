package com.wsiiz.repairshop.enterprise.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity
@ToString(exclude = "employee")

public class EmployeeSkills extends BaseEntity {
@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "idDepartment")
    Employee employee;

}
