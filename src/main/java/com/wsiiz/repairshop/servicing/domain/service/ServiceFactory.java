package com.wsiiz.repairshop.servicing.domain.service;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import com.wsiiz.repairshop.servicing.domain.service.initialtaskpolicy.CarInitialTaskPolicy;
import com.wsiiz.repairshop.servicing.domain.service.initialtaskpolicy.InitialTaskPolicy;
import com.wsiiz.repairshop.servicing.domain.service.initialtaskpolicy.TruckInitialTaskPolicy;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory implements AbstractFactory<Service> {

  @Override
  public Service create() {
    Service service = new Service();
    service.setRequiresWashing(false);
    return service;
  }

  public InitialTaskPolicy switchInitialTasksPolicy(Service service) {
    switch (service.carType) {
      case CAR:
        return new CarInitialTaskPolicy();
      case TRUCK:
        return new TruckInitialTaskPolicy();
    }
    return null;
  }

}