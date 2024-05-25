package com.von.officetel.officetel.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Builder
@Data
@Component
public class OfficetelDTO {

    private Long id;
    private String address;
    private String buildingName;
    private Long area;
    private Long unitNumber;

    @QueryProjection
    public OfficetelDTO(Long id, String address, String buildingName, Long area, Long unitNumber) {
        this.id = id;
        this.address = address;
        this.buildingName = buildingName;
        this.area = area;
        this.unitNumber = unitNumber;
    }
}
