package com.von.officetel.officetel.repository;

import com.von.officetel.officetel.model.OfficetelDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficetelDAO {

    List<OfficetelDTO> getAllOfficetel(Pageable pageable);

    List<OfficetelDTO> getOfficetelDynamic(OfficetelDTO dto, Long lowCost, Long maxCost, Pageable pageable);
}
