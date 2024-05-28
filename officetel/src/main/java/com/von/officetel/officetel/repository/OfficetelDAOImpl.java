package com.von.officetel.officetel.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.von.officetel.officetel.model.Officetel;
import com.von.officetel.officetel.model.OfficetelDTO;
import com.von.officetel.officetel.model.QOfficetel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficetelDAOImpl implements OfficetelDAO {

    private final JPAQueryFactory factory;

    private final QOfficetel officetel = QOfficetel.officetel;

    public List<OfficetelDTO> getAllOfficetel(Pageable pageable){
        return factory.selectFrom(officetel)
                .offset((pageable.getPageNumber() - 1) + pageable.getPageSize())
                .limit(pageable.getPageSize())
                .fetch()
                .stream()
                .map(OfficetelDAOImpl::entityToDto)
                .toList();
    }

    public List<OfficetelDTO> getOfficetelDynamic(OfficetelDTO dto, Long lowCost, Long maxCost, Pageable pageable){
        BooleanBuilder builder = new BooleanBuilder();

        if(dto.getOwnerType() != null){
            builder.and(officetel.ownerType.eq(dto.getOwnerType()));
        }
        if(dto.getPropertyType() != null){
            builder.and(officetel.propertyType.eq(dto.getPropertyType()));
        }

        return factory.selectFrom(officetel)
                .offset((pageable.getPageNumber() - 1) + pageable.getPageSize())
                .limit(pageable.getPageSize())
                .where(builder)
                .fetch()
                .stream()
                .map(OfficetelDAOImpl::entityToDto)
                .toList();
    }

    static OfficetelDTO entityToDto(Officetel officetel){
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

}
