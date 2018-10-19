package com.apap.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.dialect.*;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;
import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {
	@Autowired
	private JabatanService jabatanService;
	
	@Autowired
	private JabatanDb jabatanDb;
	
	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.GET)
	private String pageAddJabatan(Model model) {
		model.addAttribute("jabatan", new JabatanModel());
		return "add-jabatan";
	}
	
	@RequestMapping(value = "/jabatan/tambah", method = RequestMethod.POST)
	private String addJabatan(@ModelAttribute JabatanModel jabatan){
		jabatanService.addJabatan(jabatan);
		return "save-data";
	}
	
	@RequestMapping(value= "/jabatan/view", method = RequestMethod.GET)
	private String viewJabatan(@RequestParam(value="idJabatan") Long idJabatan, Model model) {
		JabatanModel jabatan = jabatanService.getJabatanById(idJabatan);
		model.addAttribute("jabatan", jabatan);
		return "view-jabatan";
	}
}
