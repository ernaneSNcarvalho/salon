package com.salon.salon.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.salon.salon.entities.Appointment;
import com.salon.salon.entities.Salon;
import com.salon.salon.entities.User;

public class AppointmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate appointmentDate;
    private Salon salon;
    private User user; // Referência ao cliente (User)
    private String customerWhatsapp; // O campo do WhatsApp será retirado da entidade Appointment e ficará aqui

    // Construtores
    public AppointmentDTO() {
    }

    public AppointmentDTO(Long id, LocalDate appointmentDate, Salon salon, User user, String customerWhatsapp) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.salon = salon;
        this.user = user;
        this.customerWhatsapp = customerWhatsapp; // Recebendo WhatsApp do usuário
    }

    // Construtor para conversão de Appointment entity para AppointmentDTO
    public AppointmentDTO(Appointment entity) {
        this.id = entity.getId();
        this.appointmentDate = entity.getAppointmentDate();
        this.salon = entity.getSalon();
        this.user = entity.getUser(); // Obtendo o usuário
    }

    // Métodos de acesso (getters e setters)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCustomerWhatsapp() {
        return customerWhatsapp;
    }

    public void setCustomerWhatsapp(String customerWhatsapp) {
        this.customerWhatsapp = customerWhatsapp;
    }
}
