package com.von.officetel.lease.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.von.officetel.lease.model.QLease;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaseDAOImpl implements LeaseDAO {

    private final JPAQueryFactory factory;

    private final QLease lease = QLease.lease;



}
