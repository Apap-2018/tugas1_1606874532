package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;

@Service
@Transactional
public interface PegawaiService {
	int countGaji(PegawaiModel pegawai);
    PegawaiModel getPegawaiDetailByNip(String nip);
    Optional<PegawaiModel> getPegawaiDetailById(Long id);
    
    void deletePegawai(PegawaiModel pegawai);
    
    void addPegawai(PegawaiModel pegawai);
    
    double getGajiLengkapByNip(String nip);
    List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi);
}
