package com.bangez.api.officetel.controller;

import com.bangez.api.officetel.model.OfficetelDTO;
import com.bangez.api.officetel.repository.OfficetelDAOImpl;
import com.bangez.api.officetel.repository.OfficetelRepository;
import com.bangez.api.officetel.service.OfficetelService;
import com.bangez.api.officetel.service.OfficetelServiceImpl;
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
