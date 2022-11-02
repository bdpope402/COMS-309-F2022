package com.infoFootball.SpringBackend.Concessions.Vendor;

import com.infoFootball.SpringBackend.Concessions.Vendor.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {

    Vendor findByName(String name);
    Vendor findByVendorId(int vendorId);

    @Transactional
    Vendor deleteByName(String name);
    @Transactional
    Vendor deleteByVendorId(int vendorId);
}
