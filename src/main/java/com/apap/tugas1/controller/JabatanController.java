package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.JabatanService;

@Controller
public class JabatanController {
    @Autowired
    private JabatanService jabatanService;
    @Autowired
    private JabatanPegawaiService jabatanPegawaiService;


    @GetMapping(value = "/jabatan/tambah")
    private String tambahJabatan(Model model){
        JabatanModel jabatan = new JabatanModel();
        return "add-jabatan";
    }

    @PostMapping(value = "/jabatan/tambah")
    private String tambahJabatanDone(@ModelAttribute JabatanModel jabatan, Model model){
        jabatanService.addJabatan(jabatan);
        model.addAttribute("jabatan", jabatan);
        return "addJabatanDone";
    }

    @GetMapping(value = "/jabatan/view")
    private String lihatJabatan(@RequestParam(value="idJabatan") Long id, Model model) {
        JabatanModel jabatan = jabatanService.getJabatanById(id).get();
        model.addAttribute("jabatan", jabatan);
        return "view-jabatan";
    }

    @GetMapping(value = "/jabatan/ubah")
    private String ubahJabatan(@RequestParam(value = "idJabatan") String id, Model model){
        JabatanModel jabatan = jabatanService.getJabatanById(Long.parseLong(id)).get();
        model.addAttribute("jabatan", jabatan);
        return "update-jabatan";
    }

    @PostMapping(value = "/jabatan/ubah")
    private String ubahJabatanDone(@ModelAttribute JabatanModel jabatan, Model model){
        Long id = jabatan.getId();
        jabatanService.updateJabatan(id, jabatan);
        model.addAttribute("jabatan", jabatan);
        return "updateJabatanDone";
    }

    @PostMapping (value = "/jabatan/hapus")
    private String hapusJabatan(@ModelAttribute JabatanModel jabatan, Model model){
        List<JabatanPegawaiModel> listJapPeg = jabatanPegawaiService.findAllByJabatan_Id(jabatan.getId());
        if (listJapPeg.isEmpty()){
            jabatanService.deleteJabatan(jabatan);
            model.addAttribute("jabatan", jabatan);
            return "deleteJabatanDone";
        }
        else {
            model.addAttribute("jabatan",jabatan);
            return "deleteJabatanWarning";
        }
    }

    @GetMapping(value = "/jabatan/viewall")
    private String viewAll(Model model){
        List<JabatanModel> semuaJabatan = jabatanService.getAll();
        model.addAttribute("allJabatan", semuaJabatan);
        return "view-all";
    }

}
