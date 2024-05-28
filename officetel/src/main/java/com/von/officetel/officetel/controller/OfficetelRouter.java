package com.von.officetel.officetel.controller;

import com.von.officetel.officetel.model.OfficetelDTO;
import com.von.officetel.officetel.repository.OfficetelDAOImpl;
import com.von.officetel.officetel.repository.OfficetelRepository;
import com.von.officetel.officetel.service.OfficetelService;
import com.von.officetel.officetel.service.OfficetelServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OfficetelRouter {

    private final OfficetelDAOImpl service;

    public List<?> execute(String type, OfficetelDTO dto, Long lowCost, Long maxCost, Pageable pageable) {

        return switch (type){
            case "1" -> service.getAllOfficetel(pageable);
            case "2" -> service.getOfficetelDynamic(dto, lowCost, maxCost, pageable);

            default -> null;
        };
    }
}
