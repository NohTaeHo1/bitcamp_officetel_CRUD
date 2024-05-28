package com.von.officetel.officetel.service;

import com.von.officetel.common.model.MessengerVo;
import com.von.officetel.officetel.model.Officetel;
import com.von.officetel.officetel.model.OfficetelDTO;
import com.von.officetel.officetel.repository.OfficetelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class OfficetelServiceImpl implements OfficetelService {

    private final OfficetelRepository repository;

    @Override
    public Long countOfficetel() {
        return repository.count();
    }

    @Override
    public List<OfficetelDTO> findAll() {
        return repository.findAll().stream().map(this::entityToDto).toList();
    }

    @Override
    public Optional<OfficetelDTO> findById(Long id){
        return repository.findById(id).map(this::entityToDto);
    }

    @Override
    public MessengerVo insert(OfficetelDTO dto){
        repository.insert(dtoToEntity(dto));
        return MessengerVo.builder()
                .message(repository.findById(dto.getId()).isPresent()?"SUCCESS":"FAILURE")
                .build();
    }

    @Override
    public MessengerVo modify(OfficetelDTO dto){
        Officetel entity = dtoToEntity(dto);
        repository.modify(dtoToEntity(dto));
        return MessengerVo.builder()
                .message(repository.findById(dto.getId()).get().equals(entity)?"SUCCESS":"FAILURE")
                .build();
    }

    @Override
    public MessengerVo removebyId(Long id){
        repository.removebyId(id);
        return MessengerVo.builder()
                .message(repository.findById(id).isEmpty()?"SUCCESS":"FAILURE")
                .build();
    }
}
