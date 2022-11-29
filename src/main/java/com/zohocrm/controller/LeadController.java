package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.Entities.Contact;
import com.zohocrm.Entities.Lead;
import com.zohocrm.service.ContactService;
import com.zohocrm.service.LeadService;

@Controller
public class LeadController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewCreateLead")
	public String viewCreateLead() {
		return "create_Lead";
	}
	
	@RequestMapping("/savelead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@RequestParam ("email") String email, ModelMap model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@RequestMapping("/convertLead")
	public String convertOneLead(@RequestParam("id")long id) {
		Lead lead = leadService.getOneLead(id);
		
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveOneContact(contact);
		
		leadService.deleteConvertedLead(id);
		return "";
	}
	
	@RequestMapping("/listall")
	public String listall(ModelMap model) {
		List<Lead> leads = leadService.listall();
		model.addAttribute("leads", leads);
		return "list_lead";
	}
	
	@RequestMapping("/leadinfo")
	public String getOneId(@RequestParam("id")long id, ModelMap model) {
		Lead lead = leadService.getOneLead(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
