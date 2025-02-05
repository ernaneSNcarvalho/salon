package com.salon.salon.dto;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Instant;
import java.util.List;
import java.util.Set;

import com.salon.salon.entities.Salon;

public class SalonDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String address;
    private String whatsapp;
    private String imgUrl;
    private String openingTime;
    private String closingTime;
    private Integer serviceInterval;
    private Set<DayOfWeek> workingDays;
    private List<Instant> holidayBlocks;

    public SalonDTO() {}

    public SalonDTO(Long id, String name, String address, String whatsapp, String imgUrl,
                    String openingTime, String closingTime, Integer serviceInterval,
                    Set<DayOfWeek> workingDays, List<Instant> holidayBlocks) {
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

    public SalonDTO(Salon entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.whatsapp = entity.getWhatsapp();
        this.imgUrl = entity.getImgUrl();
        this.openingTime = entity.getOpeningTime() != null ? entity.getOpeningTime().toString() : null;
        this.closingTime = entity.getClosingTime() != null ? entity.getClosingTime().toString() : null;
        this.serviceInterval = entity.getServiceInterval();
        this.workingDays = entity.getWorkingDays();
        this.holidayBlocks = entity.getHolidayBlocks();
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

    public String getOpeningTime() { return openingTime; }
    public void setOpeningTime(String openingTime) { this.openingTime = openingTime; }

    public String getClosingTime() { return closingTime; }
    public void setClosingTime(String closingTime) { this.closingTime = closingTime; }

    public Integer getServiceInterval() { return serviceInterval; }
    public void setServiceInterval(Integer serviceInterval) { this.serviceInterval = serviceInterval; }

    public Set<DayOfWeek> getWorkingDays() { return workingDays; }
    public void setWorkingDays(Set<DayOfWeek> workingDays) { this.workingDays = workingDays; }

    public List<Instant> getHolidayBlocks() { return holidayBlocks; }
    public void setHolidayBlocks(List<Instant> holidayBlocks) { this.holidayBlocks = holidayBlocks; }
}
