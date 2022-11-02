package com.infoFootball.SpringBackend.Concessions.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {

    @Autowired
    VendorRepository vendorRepository;

    /**
     * Gets a single vendor by name
     * @param vendorName name of vendor
     * @return JSON object of vendor
     */
    @GetMapping(path = "/vendors/{vendorName}")
    Vendor getOneVendor(@PathVariable String vendorName) {
        return vendorRepository.findByName(vendorName);
    }

    /**
     * Gets all vendors
     * @return List of vendors
     */
    @GetMapping(path = "/vendor/all")
    List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    /**
     * Creates and saves a new vendor to the database
     * @param newVendor JSON vendor object
     * @return Success string if completed
     */
    @PostMapping(path = "/vendor/register")
    String createVendor(@RequestBody Vendor newVendor) {
        vendorRepository.save(newVendor);
        return "Success";
    }

    /**
     * Updates a vendor with a new vendor
     * @param newVendor JSON object of new vendor
     * @param oldVendorName String of old vendor name
     * @return JSON of updated vendor object
     */
    @PutMapping(path = "/vendor/update/{vendorName}")
    Vendor updateVendor(@RequestBody Vendor newVendor, @PathVariable String oldVendorName) {
        Vendor oldVendor = vendorRepository.findByName(oldVendorName);
        if (oldVendor == null) {
            return null;
        }
        vendorRepository.save(newVendor);
        return vendorRepository.findByName(oldVendorName);
    }

    /**
     * Removes a vendor from the database
     * @param vendorName name of vendor to be removed
     * @return Success string if completed
     */
    @DeleteMapping(path = "/vendor/delete/{vendorName}")
    String deleteVendor(@PathVariable String vendorName) {
        vendorRepository.deleteByName(vendorName);
        return "Success";
    }
}
