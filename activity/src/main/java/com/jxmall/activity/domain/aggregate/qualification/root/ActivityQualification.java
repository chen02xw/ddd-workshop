package com.jxmall.activity.domain.aggregate.qualification.root;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityQualification {

    private String id;

    private String name;

    private String content;

    private Date startDate;

    private Date endDate;
}
