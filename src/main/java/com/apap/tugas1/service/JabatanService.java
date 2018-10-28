package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;


@Service
@Transactional
public interface JabatanService {
    Optional<JabatanModel> getJabatanById(Long id);

    void addJabatan(JabatanModel jabatan);

    void deleteJabatan(JabatanModel jabatan);

    List<JabatanModel> getAll();

    void updateJabatan(Long id, JabatanModel jabatan);
    }
