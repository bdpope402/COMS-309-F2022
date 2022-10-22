package com.infoFootball.SpringBackend.Concessions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDBRepository extends JpaRepository<MenuDB, String> {

    MenuDB findByVendorKey(int vendorKey);

    MenuDB deleteByVendorKey(int vendorKey);
}
