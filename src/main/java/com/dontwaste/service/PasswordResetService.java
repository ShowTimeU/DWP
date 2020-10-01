package com.dontwaste.service;

public interface PasswordResetService {

    void createRequestToPasswordReset(String email);
    boolean checkChangePasswordRequest(Long id, String token);
    void changeUserPassword(Long id, String newPassword);
    void deleteRequestToPasswordReset(Long id);

}
