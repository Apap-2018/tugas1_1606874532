package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.repository.JabatanDb;
import com.apap.tugas1.repository.JabatanPegawaiDb;

@Service
@Transactional
public class JabatanServiceImpl implements JabatanService{
    @Autowired
    private JabatanDb jabatanDb;
    
    /*@Autowired
    private JabatanPegawaiDb jabatanPegawaiDB;
*/
    public List<JabatanModel> getListJabatan(){
    	return jabatanDb.findAll();
    }
    
    public JabatanModel getJabatanById(Long id){
        return jabatanDb.getOne(id);
    }

    public void updateJabatan(Long id, JabatanModel jabatan){
        JabatanModel jabatanUpdated = jabatanDb.getOne(id);
        jabatanUpdated.setDeskripsi(jabatan.getDeskripsi());
        jabatanUpdated.setGajiPokok(jabatan.getGajiPokok());
        jabatanUpdated.setNama(jabatan.getNama());
        jabatanDb.save(jabatanUpdated);
    }

    public void addJabatan(JabatanModel jabatan){
        jabatanDb.save(jabatan);
    }
    
    public void deleteJabatanById(Long id) {
    	jabatanDb.deleteById(id);
    }

/*    public void deleteJabatan(JabatanModel jabatan){
        JabatanDb.deleteById(jabatan.getId());
    }
*/
  /*  public List<JabatanModel> getAll(){
        return JabatanDb.findAll();
    }*/
}
