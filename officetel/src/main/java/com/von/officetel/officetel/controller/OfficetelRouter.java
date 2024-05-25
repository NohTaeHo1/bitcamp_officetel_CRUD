package com.von.officetel.officetel.controller;

import com.von.officetel.officetel.repository.OfficetelDAOImpl;
import com.von.officetel.officetel.repository.OfficetelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class OfficetelRouter {

    private final OfficetelRepository repository;
    private final OfficetelDAOImpl DAOservice;

    public List<?> execute(String type, int pageNumber, int pageSize) {

        return switch (type){

            //case "6" -> repository.getPlayersLimit(PageRequest.of(0, 3));


            default -> null;
        };
    }
}
