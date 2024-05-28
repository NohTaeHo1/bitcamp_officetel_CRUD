package com.von.officetel.officetel.repository;

import com.von.officetel.officetel.model.Officetel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OfficetelJPQLRepository extends JpaRepository<Officetel, Long> {

    @Transactional
    @Modifying
    @Query(value="insert into Officetel (owner_type, building_name, address, property_type, price, area, floor, direction, description, owner, listing_date) values " +
            "(:#{#entity.ownerType}, :#{#entity.buildingName}, :#{#entity.address}, :#{#entity.propertyType}, :#{#entity.price}, :#{#entity.area}, :#{#entity.floor}, :#{#entity.direction}, :#{#entity.description}, :#{#entity.owner}, :#{#entity.listingDate})",
            nativeQuery = true)
    void insert(@Param("entity") Officetel entity);

    @Transactional
    @Modifying
    @Query("update Officetel o set o.ownerType = :#{#entity.ownerType}, o.buildingName = :#{#entity.buildingName}, o.address = :#{#entity.address}, o.propertyType = :#{#entity.propertyType}, " +
            "o.price = :#{#entity.price}, o.area = :#{#entity.area}, o.floor = :#{#entity.floor}, o.direction = :#{#entity.direction}, o.description = :#{#entity.description}, " +
            "o.owner = :#{#entity.owner}, o.listingDate = :#{#entity.listingDate} where o.id = :#{#entity.id}")
    void modify(@Param("entity") Officetel entity);

    @Transactional
    @Modifying
    @Query("delete from Officetel o where o.id = :id")
    void removebyId(@Param("id") Long id);

}
