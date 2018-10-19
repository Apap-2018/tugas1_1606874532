package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.model.JabatanModel;
import com.apap.tugas1.model.PegawaiModel;
import com.apap.tugas1.model.ProvinsiModel;
import com.apap.tugas1.repository.PegawaiDb;

@Service
@Transactional
public class PegawaiServiceImpl {
    @Autowired
    private PegawaiDb PegawaiDb;

    /*@Override*/
    public PegawaiModel getPegawaiDetailByNip(String nip) {
        return PegawaiDb.findByNip(nip);
    }

    public Optional<PegawaiModel> getPegawaiDetailById(Long id) {
        return PegawaiDb.findById(id);
    }
    
    
    /*@Override*/
    public void addPegawai(PegawaiModel pegawai){
        PegawaiDb.save(pegawai);
    }

 /*   //@Override
    public List<PegawaiModel> getAllPegawai(){
        return PegawaiDb.findAll();
    }*/
    
    //@Autowired
	public void deletePegawai(PegawaiModel pegawai) {
    	PegawaiDb.save(pegawai);
    }

    //@Override
	public int countGaji(PegawaiModel pegawai) {
		
		double gaji = 0;
		
		InstansiModel instansi = pegawai.getInstansi();
		ProvinsiModel provinsi = instansi.getProvinsi();
		double persentase = provinsi.getPresentaseTunjangan();
		
		for(JabatanModel jabatan : pegawai.getJabatanList()) {
			if(jabatan.getGajiPokok() > gaji) {
				gaji = jabatan.getGajiPokok();
			
			}
		}
		gaji += persentase/100* gaji;
		
		return (int)gaji;
		
	}    
    
    //@Override
    public double getGajiLengkapByNip(String nip) {
        double gajiLengkap = 0;
        
        PegawaiModel pegawai = this.getPegawaiDetailByNip(nip);
        
        double gajiTerbesar = 0;
        for (JabatanModel jabatan:pegawai.getJabatanList()) {
            if (jabatan.getGajiPokok() > gajiTerbesar) {
                gajiTerbesar = jabatan.getGajiPokok();
            }
        }
        System.out.println("Pokok: " + gajiTerbesar);
        gajiLengkap += gajiTerbesar;
        double presentaseTunjangan = pegawai.getInstansi().getProvinsi().getPresentaseTunjangan();
        System.out.println("Presentase: " + presentaseTunjangan);
        gajiLengkap += (gajiLengkap * presentaseTunjangan/100);
        System.out.println("Lengkap: " + gajiLengkap);
        return gajiLengkap;
    }

    //@Override
    public List<PegawaiModel> findByInstansiOrderByTanggalLahirAsc(InstansiModel instansi){
        return PegawaiDb.findByInstansiOrderByTanggalLahirAsc(instansi);
    }	
	
	/*private List<PegawaiModel> archivePegawai;
*/
}
