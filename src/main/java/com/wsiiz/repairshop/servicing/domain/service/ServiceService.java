package com.wsiiz.repairshop.servicing.domain.service;

import com.wsiiz.repairshop.foundation.domain.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceService implements AbstractService<Service> {

  @Autowired
  ServiceFactory serviceFactory;

  @Autowired
  ServiceRepository serviceRepository;

  @Override
  public Service add(Service service) {
    service.setTasks(serviceFactory.switchInitialTasksPolicy(service).generateTasks(service));
    return serviceRepository.save(service);
  }

}
