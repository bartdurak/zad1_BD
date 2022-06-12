package com.wsiiz.repairshop.enterprise.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@DiscriminatorValue("Employee")
@Entity

public class Employee extends BaseEntity {
    String firstName;
    String lastName;
    Long idDepartment;
    LocalDateTime dateOfEmployment;

    @Enumerated(value = EnumType.STRING)
    private  TypeOfPosition typeOfPosition;

    @OneToMany (mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<EmployeeSkills> employeeSkills;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDepartment", updatable = false, insertable = false)
    @JsonIgnore
    Branch branch;

}
