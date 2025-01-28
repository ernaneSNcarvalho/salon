package com.salon.salon.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private String customerWhatsapp;
	private LocalDate appointmentDate;
	private Salon salon;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateddAt;
	
	public Appointment() {
	}

	public Appointment(Long id, String customerName, String customerWhatsapp, LocalDate appointmentDate, Salon salon) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerWhatsapp = customerWhatsapp;
		this.appointmentDate = appointmentDate;
		this.salon = salon;
	}

	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		updateddAt = Instant.now();
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(id, other.id);
	}
}
