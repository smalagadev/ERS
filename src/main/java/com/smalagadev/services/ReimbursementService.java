package com.smalagadev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smalagadev.models.Reimbursement;
import com.smalagadev.repositories.ReimbursementRepository;

@Service
public class ReimbursementService {

	@Autowired
	private ReimbursementRepository dao;
	
	public List<Reimbursement> findAll() {
		return dao.findAll();
	}
	
	public Reimbursement upsert(Reimbursement r) {
		Optional<Reimbursement> exists = dao.findById(r.getId());
		if(exists.isPresent()) {
			Reimbursement found = exists.get();
			found.setId(r.getId());
			found.setAmount(r.getAmount());
			found.setSubmitted(r.getSubmitted());
			found.setResolved(r.getResolved());
			found.setDescription(r.getDescription());
			found.setAuthor(r.getAuthor());
			found.setResolver(r.getResolver());
			found.setStatus_id(r.getStatus_id());
			found.setType_id(r.getType_id());
			return dao.save(found);
		} else {
			return dao.save(r);
		}
	}
}
