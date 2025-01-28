package com.salon.salon.dto;

import com.salon.salon.entities.Salon;

public class SalonDTO {
	private Long id;
	private String name;
	private String address;
	private String whatsapp;
	
	public SalonDTO() {}

	public SalonDTO(Long id, String name, String address, String whatsapp) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.whatsapp = whatsapp;
	}
	
	public SalonDTO(Salon entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.address = entity.getAddress();
		this.whatsapp = entity.getWhatsapp();
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
