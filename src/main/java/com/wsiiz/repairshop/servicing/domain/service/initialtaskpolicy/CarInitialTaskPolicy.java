package com.wsiiz.repairshop.servicing.domain.service.initialtaskpolicy;

import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.service.Task;
import java.util.ArrayList;
import java.util.List;

public class CarInitialTaskPolicy implements InitialTaskPolicy {

  @Override
  public List<Task> generateTasks(Service service) {
    List<Task> tasks = new ArrayList<>();
    tasks.add(new Task(service, "Wash the car", null));
    return tasks;
  }

}
