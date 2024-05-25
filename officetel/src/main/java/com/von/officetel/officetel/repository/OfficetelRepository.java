package com.von.officetel.officetel.repository;

import com.von.officetel.officetel.model.Officetel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficetelRepository extends JpaRepository<Officetel, Long>, OfficetelDAO {
}
