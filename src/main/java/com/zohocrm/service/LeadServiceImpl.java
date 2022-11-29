package com.zohocrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.Entities.Lead;
import com.zohocrm.Repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}

	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		return findById.get();
	}

	@Override
	public void deleteConvertedLead(long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public List<Lead> listall() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
}