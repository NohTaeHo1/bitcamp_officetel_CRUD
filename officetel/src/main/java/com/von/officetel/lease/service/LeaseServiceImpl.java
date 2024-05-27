package com.von.officetel.lease.service;

import com.von.officetel.common.model.MessengerVo;
import com.von.officetel.lease.model.Lease;
import com.von.officetel.lease.model.LeaseDTO;
import com.von.officetel.lease.repository.LeaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class LeaseServiceImpl implements LeaseService {

    private final LeaseRepository repository;

    @Override
    public Long countOfficetel() {
        return repository.count();
    }

    @Override
    public List<LeaseDTO> findAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<LeaseDTO> findById(Long id){
        return repository.findById(id).map(this::entityToDto);
    }

    @Override
    public MessengerVo insert(LeaseDTO dto){
        repository.insert(dtoToEntity(dto));
        return MessengerVo.builder()
                .message(repository.findById(dto.getId()).isPresent()?"SUCCESS":"FAILURE")
                .build();
    }

}
