package com.smalagadev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smalagadev.models.Reimbursement;
import com.smalagadev.services.ReimbursementService;

@RestController
public class ReimbursementController {
	
	@Autowired
	private ReimbursementService rs;
	
	@GetMapping("/reimbursements")
	public ResponseEntity<List<Reimbursement>> findAllReimbursements() {
		List<Reimbursement> reimbursements = rs.findAll();
		if(reimbursements.size() > 0) {
			return ResponseEntity.ok(reimbursements);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/reimbursements")
	public ResponseEntity<Reimbursement> upsert(@RequestBody Reimbursement r) {
		if(r != null) {
			return ResponseEntity.ok(rs.upsert(r));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
