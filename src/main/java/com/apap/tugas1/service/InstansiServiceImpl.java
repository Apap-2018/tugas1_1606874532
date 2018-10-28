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
public class InstansiServiceImpl implements InstansiService{
    @Autowired
    private InstansiDb instansiDb;

    public Optional<InstansiModel> getInstansiById(long idInstansi){
        return instansiDb.findById(idInstansi);
    }

    public List<InstansiModel> getAllInstansi(){
        return instansiDb.findAll();
    }
}
