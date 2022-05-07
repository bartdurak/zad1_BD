package com.wsiiz.repairshop.servicing.domain.servicerequest;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceRequestFactory implements AbstractFactory<ServiceRequest> {

  @Override
  public ServiceRequest create() {
    return new ServiceRequest();
  }

}
