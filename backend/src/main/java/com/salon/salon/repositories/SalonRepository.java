package com.salon.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salon.salon.entities.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {

}
