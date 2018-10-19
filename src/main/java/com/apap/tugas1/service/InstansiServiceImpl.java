package com.apap.tugas1.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas1.model.InstansiModel;
import com.apap.tugas1.repository.InstansiDb;

@Service
@Transactional
public class InstansiServiceImpl {
    @Autowired
    private InstansiDb instansiDB;

/*    public Optional<InstansiModel> getInstansiById(long idInstansi){
        return InstansiDb.findById(idInstansi);
    }

    public List<InstansiModel> getAllInstansi(){
        return InstansiDb.findAll();
    }
*/	
}
