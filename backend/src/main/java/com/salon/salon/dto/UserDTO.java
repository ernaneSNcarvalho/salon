package com.salon.salon.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.salon.salon.entities.User;
import com.salon.salon.validations.ValidWhatsAppNumber;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	@ValidWhatsAppNumber
	private String whatsapp;
	private String email;
	private String address;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String whatsapp, String email, String address, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.whatsapp = whatsapp;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.whatsapp = entity.getWhatsapp();
        this.email = entity.getEmail();
        this.address = entity.getAddress();
        this.birthDate = (entity.getBirthDate());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDateAsLocalDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
