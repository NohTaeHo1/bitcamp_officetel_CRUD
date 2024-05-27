package com.von.officetel.lease.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Builder
@Data
@Component
public class LeaseDTO {

    private Long id;
    private String buildingName;
    private String address;
    private String propertyType;
    private String price;
    private String area;
    private String floor;
    private String direction;
    private String description;
    private String owner;
    private String listingDate;

    @QueryProjection
    public LeaseDTO(Long id, String buildingName, String address, String propertyType, String price, String area, String floor, String direction, String description, String owner, String listingDate) {
        this.id = id;
        this.buildingName = buildingName;
        this.address = address;
        this.propertyType = propertyType;
        this.price = price;
        this.area = area;
        this.floor = floor;
        this.direction = direction;
        this.description = description;
        this.owner = owner;
        this.listingDate = listingDate;
    }


}
