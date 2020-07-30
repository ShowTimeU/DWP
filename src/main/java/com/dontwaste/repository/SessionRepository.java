package com.dontwaste.repository;

import com.dontwaste.model.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findByToken(String token);
    void deleteByToken(String token);

}
