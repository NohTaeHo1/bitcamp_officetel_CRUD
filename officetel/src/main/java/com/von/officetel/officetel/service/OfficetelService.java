package com.von.officetel.officetel.service;

import com.von.officetel.common.model.MessengerVo;
import com.von.officetel.officetel.model.Officetel;
import com.von.officetel.officetel.model.OfficetelDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OfficetelService {

    Long countOfficetel();
    List<OfficetelDTO> findAll();
    Optional<OfficetelDTO> findById(Long id);
    MessengerVo insert(OfficetelDTO dto);
    MessengerVo modify(OfficetelDTO dto);
    MessengerVo removebyId(Long id);



    default OfficetelDTO entityToDto(Officetel officetel){
        return OfficetelDTO.builder()
                .id(officetel.getId())
                .ownerType(officetel.getOwnerType())
                .buildingName(officetel.getBuildingName())
                .address(officetel.getAddress())
                .propertyType(officetel.getPropertyType())
                .price(officetel.getPrice())
                .area(officetel.getArea())
                .floor(officetel.getFloor())
                .direction(officetel.getDirection())
                .description(officetel.getDescription())
                .owner(officetel.getOwner())
                .listingDate(officetel.getListingDate())
                .monthlyRent(officetel.getMonthlyRent())
                .build();
    }

    default Officetel dtoToEntity(OfficetelDTO dto){
        LocalDate localdate = LocalDate.now();
        return Officetel.builder()
                .id(dto.getId())
                .ownerType(dto.getOwnerType())
                .buildingName(dto.getBuildingName())
                .address(dto.getAddress())
                .propertyType(dto.getPropertyType())
                .price(dto.getPrice())
                .area(dto.getArea())
                .floor(dto.getFloor())
                .direction(dto.getDirection())
                .description(dto.getDescription())
                .owner(dto.getOwner())
                .listingDate(localdate)
                .build();
    }
}
