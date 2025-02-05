package com.salon.salon.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_appointment")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Cliente que marcou o agendamento
    
    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    private Salon salon; // Salão onde será feito o atendimento
    
    private LocalDate appointmentDate; // Data do agendamento
    
    private LocalTime appointmentTime; // Horário do agendamento
    
    @ElementCollection
    @CollectionTable(name = "tb_available_dates", joinColumns = @JoinColumn(name = "appointment_id"))
    @Column(name = "date")
    private List<LocalDate> availableDates; // Lista de datas disponíveis para agendamento
    
    @ElementCollection
    @CollectionTable(name = "tb_available_times", joinColumns = @JoinColumn(name = "appointment_id"))
    @Column(name = "time")
    private List<LocalTime> availableTimes; // Lista de horários disponíveis para agendamento
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Appointment() {
    }

    public Appointment(Long id, User user, Salon salon, LocalDate appointmentDate, LocalTime appointmentTime, List<LocalDate> availableDates, List<LocalTime> availableTimes) {
        this.id = id;
        this.user = user;
        this.salon = salon;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.availableDates = availableDates;
        this.availableTimes = availableTimes;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
    
    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public List<LocalDate> getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(List<LocalDate> availableDates) {
        this.availableDates = availableDates;
    }

    public List<LocalTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<LocalTime> availableTimes) {
        this.availableTimes = availableTimes;
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
