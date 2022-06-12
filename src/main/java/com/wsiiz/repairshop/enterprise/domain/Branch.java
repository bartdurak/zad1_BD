package com.wsiiz.repairshop.enterprise.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@DiscriminatorValue("Branch")

public class Branch extends BaseEntity  {
long id;

@Enumerated(value =EnumType.STRING)
    private TypeOfActivity typeOfActivity;

}
