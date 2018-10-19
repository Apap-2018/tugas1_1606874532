package com.apap.tugas1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.service.InstansiService;
import com.apap.tugas1.service.JabatanPegawaiService;
import com.apap.tugas1.service.JabatanService;
import com.apap.tugas1.service.PegawaiService;

@Controller
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;
    @Autowired
    private JabatanPegawaiService jabatanPegawaiService;
    @Autowired
    private JabatanService jabatanService;
    @Autowired
    private InstansiService instansiService;

    @RequestMapping("/")
    private String index(Model model) {
    	model.addAttribute("listJabatan", jabatanService.getListJabatan());
        return "index";
    }

    @GetMapping (value = "/pegawai")
    private String getPegawai(@RequestParam(value = "nip") String nipPegawai, Model model){
        PegawaiModel pegawai = pegawaiService.getPegawaiDetailByNip(nipPegawai);
        List<JabatanPegawaiModel> jabatanPegawai = jabatanPegawaiService.getJabatanByPegawaiId(nipPegawai).get();
        double gajiPegawai = pegawaiService.getGajiLengkapByNip(nipPegawai);
        long l = (new Double(gajiPegawai)).longValue();


        model.addAttribute("pegawai", pegawai);
        model.addAttribute("gajiPegawai", l);
        model.addAttribute("jabatanPegawai", jabatanPegawai);
        model.addAttribute("title", "Data Pegawai");
        return "viewPegawai";
    }

/*    @GetMapping(value = "/pegawai/termuda-tertua")
    private String viewPegawaiMudaDanTua(@RequestParam(value = "idInstansi") String idInstansi, Model model){
        InstansiModel instansiYangDicari = InstansiService.getInstansiById(Long.parseLong(idInstansi)).get();
        List<PegawaiModel> listPegawai = PegawaiService.findByInstansiOrderByTanggalLahirAsc(instansiYangDicari);
        PegawaiModel pegawaiTertua = listPegawai.get(0);
       
        System.out.println(pegawaiTertua.getNama());
        PegawaiModel pegawaiTermuda = listPegawai.get(listPegawai.size()-1);
        List<JabatanModel> jabatanPegawaiTertua = pegawaiTertua.getJabatanList();
        List<JabatanModel> jabatanPegawaiTermuda = pegawaiTermuda.getJabatanList();
        model.addAttribute("instansi", instansiYangDicari);
        model.addAttribute("pegawaiTertua", pegawaiTertua);
        model.addAttribute("pegawaiTermuda", pegawaiTermuda);
        model.addAttribute("jabatanPegawaiTertua", jabatanPegawaiTertua);
        model.addAttribute("jabatanPegawaiTermuda", jabatanPegawaiTermuda);
        return "viewPegawaiTertuaTermuda";
    }

    @GetMapping(value = ("/pegawai/tambah"))
    private String addPegawaiGet(Model model){
        return "index";
    }

    @PostMapping(value = ("pegawai/tambah"))
    private String addPegawaiPost(ModelAttribute pegawaiModel ){
        return "index";
    }*/
}
