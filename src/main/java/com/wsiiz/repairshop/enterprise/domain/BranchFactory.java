package com.wsiiz.repairshop.enterprise.domain;
import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;

@Component
public class BranchFactory implements AbstractFactory <Branch> {
    @Override
    public Branch create(){
        return new Branch();

    }
}
