package com.dontwaste.repository;

import com.dontwaste.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnifRepository extends JpaRepository<Branch, Long> {

}
