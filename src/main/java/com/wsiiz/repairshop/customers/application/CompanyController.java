package com.wsiiz.repairshop.customers.application;

import com.wsiiz.repairshop.customers.domain.customer.Company;
import com.wsiiz.repairshop.customers.domain.customer.CompanyRepository;
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
public class CompanyController {

  @Autowired
  CompanyRepository companyRepository;

  @GetMapping("/customers/companies")
  public ResponseEntity<List<Company>> getMany(
      @RequestParam(value = "name", required = false) String name) {
    return ResponseEntity.ok(companyRepository.findByCriteria(name));
  }

  @GetMapping("/customers/companies/{id}")
  public ResponseEntity<Company> getOne(@PathVariable("id") Long id) {

    Optional<Company> service = companyRepository.findById(id);

    if (service.isPresent()) {
      return ResponseEntity.ok(service.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/customers/companies")
  public ResponseEntity<Company> addNew(@RequestBody Company customer) {
    return ResponseEntity.created(null).body(companyRepository.save(customer));
  }

  @DeleteMapping("/customers/companies/{id}")
  public ResponseEntity<Company> remove(@PathVariable("id") Long id) {

    Optional<Company> customer = companyRepository.findById(id);

    if (customer.isPresent()) {
      companyRepository.deleteById(id);
      return ResponseEntity.ok(customer.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

}
