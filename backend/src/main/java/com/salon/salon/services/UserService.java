package com.salon.salon.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.salon.salon.dto.UserDTO;
import com.salon.salon.entities.User;
import com.salon.salon.repositories.UserRepository;
import com.salon.salon.resources.exceptions.DatabaseException;
import com.salon.salon.resources.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable){
		Page<User> list = repository.findAll(pageable);
		return list.map(x -> new UserDTO(x));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);		
	}
	
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("Id not found");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
	    entity.setName(dto.getName());
	    entity.setWhatsapp(dto.getWhatsapp());
	    entity.setEmail(dto.getEmail());
	    entity.setAddress(dto.getAddress());
	    entity.setBirthDate(dto.getBirthDateAsLocalDate()); // Converte String para LocalDate
	}
}
