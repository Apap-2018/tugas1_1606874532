package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.repository.PegawaiDb;

@Service
@Transactional
public class PegawaiServiceImpl implements PegawaiService{
    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel getPegawaiDetailByNip(String nip) {
        return pegawaiDb.findByNip(nip);
    }

    @Override
    public void addPegawai(PegawaiModel pegawai){
        pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> getAllPegawai(){
        return pegawaiDb.findAll();
    }

    @Override
    public List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi){
        return pegawaiDb.findByInstansiOrderByTanggalLahirAsc(instansi);
    }
}
