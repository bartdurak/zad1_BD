package com.wsiiz.repairshop.enterprise.domain;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;
@Component
public class  EmployeeFactory implements AbstractFactory <Employee> {
    @Override
    public Employee create() {
        return new Employee();

    }

}
