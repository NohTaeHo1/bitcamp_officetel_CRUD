package com.von.officetel.lease.service;

import com.von.officetel.common.model.MessengerVo;
import com.von.officetel.lease.model.Lease;
import com.von.officetel.lease.model.LeaseDTO;

import java.util.List;
import java.util.Optional;

public interface LeaseService {

    Long countOfficetel();
    List<LeaseDTO> findAll();
    Optional<LeaseDTO> findById(Long id);
    MessengerVo insert(LeaseDTO dto);

    default LeaseDTO entityToDto(Lease lease){
        return LeaseDTO.builder()
                .id(lease.getId())
                .buildingName(lease.getBuildingName())
                .address(lease.getAddress())
                .propertyType(lease.getPropertyType())
                .price(lease.getPrice())
                .area(lease.getArea())
                .floor(lease.getFloor())
                .direction(lease.getDirection())
                .description(lease.getDescription())
                .owner(lease.getOwner())
                .listingDate(lease.getListingDate())
                .build();

    }

    default Lease dtoToEntity(LeaseDTO dto){
        return Lease.builder()
                .id(dto.getId())
                .buildingName(dto.getBuildingName())
                .address(dto.getAddress())
                .propertyType(dto.getPropertyType())
                .price(dto.getPrice())
                .area(dto.getArea())
                .floor(dto.getFloor())
                .direction(dto.getDirection())
                .description(dto.getDescription())
                .owner(dto.getOwner())
                .listingDate(dto.getListingDate())
                .build();
    }
}
