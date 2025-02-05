package com.salon.salon.entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_salon")
public class Salon implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String whatsapp;
    private String imgUrl;

    private LocalTime openingTime;
    private LocalTime closingTime;
    private Integer serviceInterval;

    @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "tb_salon_working_days", joinColumns = @JoinColumn(name = "salon_id"))
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> workingDays;

    @ElementCollection
    @CollectionTable(name = "tb_salon_holidays", joinColumns = @JoinColumn(name = "salon_id"))
    @Column(name = "holiday_date")
    private List<Instant> holidayBlocks;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;

    public Salon() {}

    public Salon(Long id, String name, String address, String whatsapp, String imgUrl, LocalTime openingTime,
                 LocalTime closingTime, Integer serviceInterval, Set<DayOfWeek> workingDays, List<Instant> holidayBlocks) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.whatsapp = whatsapp;
        this.imgUrl = imgUrl;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.serviceInterval = serviceInterval;
        this.workingDays = workingDays;
        this.holidayBlocks = holidayBlocks;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getWhatsapp() { return whatsapp; }
    public void setWhatsapp(String whatsapp) { this.whatsapp = whatsapp; }

    public String getImgUrl() { return imgUrl; }
    public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }

    public LocalTime getOpeningTime() { return openingTime; }
    public void setOpeningTime(LocalTime openingTime) { this.openingTime = openingTime; }

    public LocalTime getClosingTime() { return closingTime; }
    public void setClosingTime(LocalTime closingTime) { this.closingTime = closingTime; }

    public Integer getServiceInterval() { return serviceInterval; }
    public void setServiceInterval(Integer serviceInterval) { this.serviceInterval = serviceInterval; }

    public Set<DayOfWeek> getWorkingDays() { return workingDays; }
    public void setWorkingDays(Set<DayOfWeek> workingDays) { this.workingDays = workingDays; }

    public List<Instant> getHolidayBlocks() { return holidayBlocks; }
    public void setHolidayBlocks(List<Instant> holidayBlocks) { this.holidayBlocks = holidayBlocks; }
}
