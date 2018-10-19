package com.apap.tugas1.service;

import java.util.List;

import com.apap.tugas1.model.JabatanModel;

public interface JabatanService {
	JabatanModel getJabatanById(Long id);

	List<JabatanModel> getListJabatan();
	
    void addJabatan(JabatanModel jabatan);

    void updateJabatan(Long id, JabatanModel jabatan);

    void deleteJabatanById(Long id);
}
