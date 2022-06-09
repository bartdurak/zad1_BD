package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchAddress;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchRepository;
import com.wsiiz.repairshop.enterprise.domain.branch.ParentBranch;
import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeRepository;
import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.servicerequest.RequestType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class BranchControler {
    @Autowired
    BranchRepository branchRepository;

    @GetMapping("/branches")
    public ResponseEntity<List<Branch>> getMany(
            @RequestParam(value = "city", required = false) BranchAddress city,
            @RequestParam(value = "parent_branch_name", required = false) ParentBranch parentBranchName){
        return ResponseEntity.ok(branchRepository.findBySelectionCriteria(city, parentBranchName));
    }

    @GetMapping("/branches/{id}")
    public ResponseEntity<Branch> getOne(@PathVariable("id") String id) {

        Optional<Branch> branch = branchRepository.findById(id);

        return branch.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/branches")
    public ResponseEntity<Branch> addNew(@RequestBody Branch branch) {
        branch.getEmployees().forEach(r->r.setBranch(branch));
        return ResponseEntity.created(null).body(branchRepository.save(branch));
    }

    @DeleteMapping("/branches/{id}")
    public ResponseEntity<Branch> remove(@PathVariable("id") String id) {

        Optional<Branch> branch = branchRepository.findById(id);

        if (branch.isPresent()) {
            branchRepository.deleteById(id);
            return ResponseEntity.ok(branch.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
