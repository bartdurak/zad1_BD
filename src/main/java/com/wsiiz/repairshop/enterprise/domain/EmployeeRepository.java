package com.wsiiz.repairshop.enterprise.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
List<Employee> findByidDepartment (Long idDepartment);

}
