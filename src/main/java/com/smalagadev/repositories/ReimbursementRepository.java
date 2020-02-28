package com.smalagadev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smalagadev.models.Reimbursement;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Integer> {

}
