package com.dontwaste.repository;

import com.dontwaste.model.entity.PasswordReset;
import com.dontwaste.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {

    PasswordReset findByIdAndToken(Long id, String token);
    PasswordReset findByUser(User user);

}
