package com.salon.salon.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.salon.salon.entities.Appointment;
import com.salon.salon.entities.Salon;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class SalonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private String whatsapp;
	private String imgUrl;
	
	@ManyToMany
	@JoinTable(
				name = "tb_salon_appointment",
				joinColumns = @JoinColumn(name = "salon_id"),
				inverseJoinColumns = @JoinColumn(name = "appointment_id")
			)
	Set<Appointment> list = new HashSet<>();
	
	public SalonDTO() {}

	public SalonDTO(Long id, String name, String address, String whatsapp, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.whatsapp = whatsapp;
		this.imgUrl = imgUrl;
	}
	
	public SalonDTO(Salon entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.address = entity.getAddress();
		this.whatsapp = entity.getWhatsapp();
		this.imgUrl = entity.getImgUrl();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}
}
