package com.zohocrm.service;

import java.util.List;

import com.zohocrm.Entities.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public Lead getOneLead(long id);

	public void deleteConvertedLead(long id);

	public List<Lead> listall();

}
