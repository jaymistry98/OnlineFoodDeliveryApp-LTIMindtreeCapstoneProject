package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer>{
	List<Vendor> findByUserId(int userId);
}
