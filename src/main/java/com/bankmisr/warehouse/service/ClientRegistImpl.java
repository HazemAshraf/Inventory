package com.bankmisr.warehouse.service;

import com.bankmisr.warehouse.dao.*;
import com.bankmisr.warehouse.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientRegistImpl {

    private MasterRepo masterDAO;
    private MasterPriceRepo MasterPriceDAO;
    private MasterStoreRepo MasterStoreDAO;
    @Autowired
    private ClientRegistRepo clientRegistRepo;
    @Autowired
    public ClientRegistImpl(ClientRegistRepo clientRegistRepo) {
        this.clientRegistRepo = clientRegistRepo;
    }

    public void saveClientRegist(ClientRegist c){
        clientRegistRepo.save(c);
    }

    public ClientRegist findByFileNo(String fileNo) {
        return clientRegistRepo.findByFileNo(fileNo);
    }


//	public void deleteById(Double theId) {
//		masterDAO.deleteById(theId);
//	}
}
