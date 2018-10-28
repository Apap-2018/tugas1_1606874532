package com.apap.tugas1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

@Service
@Transactional
public interface PegawaiService {
    PegawaiModel getPegawaiDetailByNip(String nip);
    void addPegawai(PegawaiModel pegawai);
    List<PegawaiModel> getAllPegawai();
    List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi);
}
