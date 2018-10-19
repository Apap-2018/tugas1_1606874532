package com.apap.tugas1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;

@Service
@Transactional
public interface JabatanService {
	JabatanModel getJabatanById(Long id);

	List<JabatanModel> getListJabatan();
	
    void addJabatan(JabatanModel jabatan);

    void updateJabatan(Long id, JabatanModel jabatan);

    void deleteJabatanById(Long id);
}
