package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

    Vendor findByName(String name);
    //Vendor findById(int Id);

    Vendor deleteByName(String name);
    //Vendor deleteById(int Id);
}
