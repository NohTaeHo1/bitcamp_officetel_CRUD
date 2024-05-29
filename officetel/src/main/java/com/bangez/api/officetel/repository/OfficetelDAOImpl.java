package com.bangez.api.officetel.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.bangez.api.officetel.model.OfficetelModel;
import com.bangez.api.officetel.model.OfficetelDTO;
import com.bangez.api.officetel.model.QOfficetelModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficetelDAOImpl implements OfficetelDAO {

    private final JPAQueryFactory factory;
    private final QOfficetelModel officetel = QOfficetelModel.officetelModel;

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

    static OfficetelDTO entityToDto(OfficetelModel officetelModel){
        return OfficetelDTO.builder()
                .id(officetelModel.getId())
                .ownerType(officetelModel.getOwnerType())
                .buildingName(officetelModel.getBuildingName())
                .addressId(officetelModel.getAddressId())
                .propertyType(officetelModel.getPropertyType())
                .price(officetelModel.getPrice())
                .area(officetelModel.getArea())
                .floor(officetelModel.getFloor())
                .direction(officetelModel.getDirection())
                .description(officetelModel.getDescription())
                .owner(officetelModel.getOwner())
                .listingDate(officetelModel.getListingDate())
                .monthlyRent(officetelModel.getMonthlyRent())
                .build();
    }

}
