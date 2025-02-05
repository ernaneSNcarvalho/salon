package com.salon.salon.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.salon.salon.dto.UserDTO;
import com.salon.salon.services.UserService;


@RestController
@RequestMapping(value = "/users")
@Validated
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@Autowired
    private PagedResourcesAssembler<UserDTO> pagedResourcesAssembler;

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<UserDTO>>> findAll(Pageable pageable) {
        Page<UserDTO> page = service.findAllPaged(pageable);
        PagedModel<EntityModel<UserDTO>> pagedModel = pagedResourcesAssembler.toModel(page);
        return ResponseEntity.ok(pagedModel);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
    	UserDTO dto = service.findById(id);
    	return ResponseEntity.ok().body(dto);
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserDTO dto){
    	dto = service.insert(dto);
    	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
    	dto = service.update(id, dto);
    	return ResponseEntity.ok().body(dto);
   }
    
   @DeleteMapping(value = "/{id}")
   public ResponseEntity<UserDTO> delete(@PathVariable Long id){
		   service.delete(id);
		   return ResponseEntity.noContent().build();
   }
}

