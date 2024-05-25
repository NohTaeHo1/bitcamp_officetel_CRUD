package com.von.officetel.officetel.service;

import com.von.officetel.officetel.model.OfficetelDTO;
import com.von.officetel.officetel.repository.OfficetelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficetelServiceImpl implements OfficetelService{
    private OfficetelRepository repository;

    @Override
    public Long countOfficetel() {
        return repository.count();
    }

    @Override
    public List<OfficetelDTO> findAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }
}
