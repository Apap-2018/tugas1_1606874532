package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

public interface PegawaiService {
    PegawaiModel getPegawaiDetailByNip(String nip);
    Optional<PegawaiModel> getPegawaiDetailById(Long id);
    void deletePegawai(PegawaiModel pegawai);
    int countGaji(PegawaiModel pegawai);
    void addPegawai(PegawaiModel pegawai);
    
    List<PegawaiModel> getAllPegawai();
    double getGajiLengkapByNip(String nip);
    List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi);
}
