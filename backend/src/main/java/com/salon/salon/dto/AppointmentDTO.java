package com.salon.salon.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import com.salon.salon.entities.Appointment;
import com.salon.salon.entities.Salon;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AppointmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String customerName;
	private String customerWhatsapp;
	private LocalDate appointmentDate;
	private Salon salon;
	
	public AppointmentDTO() {
	}

	public AppointmentDTO(Long id, String customerName, String customerWhatsapp, LocalDate appointmentDate,
			Salon salon) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerWhatsapp = customerWhatsapp;
		this.appointmentDate = appointmentDate;
		this.salon = salon;
	}
	
	public AppointmentDTO(Appointment entity) {
		this.id = entity.getId();
		this.customerName = entity.getCustomerName();
		this.customerWhatsapp = entity.getCustomerWhatsapp();
		this.appointmentDate = entity.getAppointmentDate();
		this.salon = entity.getSalon();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerWhatsapp() {
		return customerWhatsapp;
	}

	public void setCustomerWhatsapp(String customerWhatsapp) {
		this.customerWhatsapp = customerWhatsapp;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

}
