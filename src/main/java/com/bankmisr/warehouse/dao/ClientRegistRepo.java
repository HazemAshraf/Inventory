package com.bankmisr.warehouse.dao;

import com.bankmisr.warehouse.entity.ClientRegist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRegistRepo extends JpaRepository<ClientRegist,Integer> {
    public ClientRegist findByFileNo(String fileNo);
}
