package com.von.officetel.lease.repository;

import com.von.officetel.lease.model.Lease;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaseRepository extends LeaseDAO, LeaseJPQLRepository {
}
