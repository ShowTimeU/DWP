package com.dontwaste.service;

import com.dontwaste.model.customer.entity.Session;
import com.dontwaste.model.customer.entity.User;

public interface SessionService {

    void addSession(Session session);
    User getUserByToken(String token);
    void deleteSessionByToken(String token);


}
