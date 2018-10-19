package com.apap.tugas1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugas1.model.JabatanPegawaiModel;

public interface JabatanPegawaiDb extends JpaRepository<JabatanPegawaiModel, Long>{
    Optional<List<JabatanPegawaiModel>> findAllByPegawai_Nip(String nip);
    List<JabatanPegawaiModel> findAllByJabatan_Id(Long id);
}
