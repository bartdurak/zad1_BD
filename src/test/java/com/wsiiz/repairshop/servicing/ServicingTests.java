package com.wsiiz.repairshop.servicing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.wsiiz.repairshop.servicing.domain.service.CarType;
import com.wsiiz.repairshop.servicing.domain.service.Service;
import com.wsiiz.repairshop.servicing.domain.service.ServiceRepository;
import com.wsiiz.repairshop.servicing.domain.service.ServiceService;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicingTests {

  @Autowired
  ServiceService serviceService;

  @Autowired
  ServiceRepository serviceRepository;

  @Test
  @Transactional
  public void shouldHaveOneTask() {

    // given

    Service service = new Service(
        CarType.CAR,
        LocalDateTime.now(),
        false,
        "",
        null);

    // when

    Service s = serviceService.add(service);
    s = serviceRepository.getOne(s.getId());

    // then

    assertThat(s != null && s.getTasks() != null && s.getTasks().size() == 1).isTrue();
  }

}
