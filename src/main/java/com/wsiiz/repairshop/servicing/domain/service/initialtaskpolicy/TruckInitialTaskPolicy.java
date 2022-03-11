package com.wsiiz.repairshop.servicing.domain.service.initialtaskpolicy;

import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.service.Task;
import java.util.List;

public class TruckInitialTaskPolicy implements InitialTaskPolicy {

  @Override
  public List<Task> generateTasks(Service service) {
    return null;
  }

}
