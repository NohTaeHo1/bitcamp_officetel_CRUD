package com.von.officetel.officetel.service;

import com.von.officetel.officetel.model.Officetel;
import com.von.officetel.officetel.model.OfficetelDTO;

import java.util.List;

public interface OfficetelService {

    Long countOfficetel();
    List<OfficetelDTO> findAll();

    default OfficetelDTO entityToDto(Officetel officetel){
        return OfficetelDTO.builder()
                .id(officetel.getId())
                .address(officetel.getAddress())
                .buildingName(officetel.getBuildingName())
                .area(officetel.getArea())
                .unitNumber(officetel.getUnitNumber())
                .build();

    }
}
