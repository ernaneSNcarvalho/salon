package com.salon.salon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salon.salon.dto.AppointmentDTO;
import com.salon.salon.entities.Appointment;
import com.salon.salon.repositories.AppointmentRepository;
import com.salon.salon.resources.exceptions.DatabaseException;
import com.salon.salon.resources.exceptions.ResourceNotFoundException;

@Service
public class AppointmentService {
	
	@Autowired
	private AppointmentRepository repository;
	
	@Transactional(readOnly = true)
	public Page<AppointmentDTO> findAllPaged(PageRequest pageRequest){
		Page<Appointment> list = repository.findAll(pageRequest);
		return list.map(x -> new AppointmentDTO(x));
	}
	
	@Transactional(readOnly = true)
	public AppointmentDTO findById(Long id) {
		Optional<Appointment> obj = repository.findById(id);
		Appointment entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not Found"));
		return new AppointmentDTO(entity);
	}

	@Transactional
	public AppointmentDTO insert(AppointmentDTO dto) {
		Appointment entity = new Appointment();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AppointmentDTO(entity);		
	}
	
	@Transactional
	public AppointmentDTO update(Long id, AppointmentDTO dto) {
		try {
			Appointment entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AppointmentDTO(entity);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found.");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found!");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation!");
		}
	}
	
	private void copyDtoToEntity(AppointmentDTO dto, Appointment entity) {
		entity.setCustomerName(dto.getCustomerName());
		entity.setCustomerWhatsapp(dto.getCustomerWhatsapp());
		entity.setAppointmentDate(dto.getAppointmentDate());
		entity.setSalon(dto.getSalon());
	}
}
