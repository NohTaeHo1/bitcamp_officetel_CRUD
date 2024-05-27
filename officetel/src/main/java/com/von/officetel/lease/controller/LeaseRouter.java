package com.von.officetel.lease.controller;

import com.von.officetel.lease.repository.LeaseDAOImpl;
import com.von.officetel.lease.repository.LeaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class LeaseRouter {

    private final LeaseRepository repository;
    private final LeaseDAOImpl DAOservice;

    public List<?> execute(String type, int pageNumber, int pageSize) {

        return switch (type){

            //case "6" -> repository.getPlayersLimit(PageRequest.of(0, 3));


            default -> null;
        };
    }
}
