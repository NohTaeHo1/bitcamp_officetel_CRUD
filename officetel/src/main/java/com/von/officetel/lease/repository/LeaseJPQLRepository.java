package com.von.officetel.lease.repository;

import com.von.officetel.lease.model.Lease;
import com.von.officetel.lease.model.LeaseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LeaseJPQLRepository extends JpaRepository<Lease, Long> {

    @Transactional
    @Modifying
    @Query(value="insert into Lease (building_name, address, property_type, price, area, floor, direction, description, owner, listing_date) values " +
            "(:#{#entity.buildingName}, :#{#entity.address}, :#{#entity.propertyType}, :#{#entity.price}, :#{#entity.area}, :#{#entity.floor}, :#{#entity.direction}, :#{#entity.description}, :#{#entity.owner}, :#{#entity.listingDate})",
            nativeQuery = true)
    void insert(@Param("entity") Lease entity);
}
