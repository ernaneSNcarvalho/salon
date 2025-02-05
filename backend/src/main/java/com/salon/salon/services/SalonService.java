package com.salon.salon.services;

import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salon.salon.dto.SalonDTO;
import com.salon.salon.entities.Salon;
import com.salon.salon.repositories.SalonRepository;
import com.salon.salon.resources.exceptions.DatabaseException;
import com.salon.salon.resources.exceptions.ResourceNotFoundException;

@Service
public class SalonService {
	
	@Autowired
	private SalonRepository repository;
	
	@Transactional(readOnly = true)
	public Page<SalonDTO> findAllPaged(PageRequest pageRequest) {
		Page<Salon> list = repository.findAll(pageRequest);
		return list.map(SalonDTO::new);
	}
	
	@Transactional(readOnly = true)
	public SalonDTO findById(Long id) {
		Optional<Salon> obj = repository.findById(id);
		Salon entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new SalonDTO(entity);
	}
	
	@Transactional
	public SalonDTO insert(SalonDTO dto) {
		Salon entity = new Salon();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new SalonDTO(entity);
	}
	
	@Transactional
	public SalonDTO update(Long id, SalonDTO dto) {
		try {
			Salon entity = repository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not found"));
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new SalonDTO(entity);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found.");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation.");
		}
	}
	
	private void copyDtoToEntity(SalonDTO dto, Salon entity) {
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setWhatsapp(dto.getWhatsapp());
		entity.setImgUrl(dto.getImgUrl());
		entity.setOpeningTime(LocalTime.parse(dto.getOpeningTime()));
		entity.setClosingTime(LocalTime.parse(dto.getClosingTime()));
		entity.setServiceInterval(dto.getServiceInterval());
		entity.setWorkingDays(dto.getWorkingDays());
		entity.setHolidayBlocks(dto.getHolidayBlocks());
	}
}
