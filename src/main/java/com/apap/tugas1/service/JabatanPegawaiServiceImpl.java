package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanPegawaiModel;
import com.apap.tugas1.repository.JabatanPegawaiDb;

@Service
@Transactional
public class JabatanPegawaiServiceImpl {
    @Autowired
    private JabatanPegawaiDb jabatanPegawaiDB;

/*    @Override
    public Optional<List<JabatanPegawaiModel>> getJabatanByPegawaiId(String nip) {
        return JabatanPegawaiDb.findAllByPegawai_Nip(nip);
    }

    @Override
    public List<jabatanPegawaiModel> findAllByJabatan_Id(Long id){
        return JabatanPegawaiDb.findAllByJabatan_Id(id);
    }*/
}
