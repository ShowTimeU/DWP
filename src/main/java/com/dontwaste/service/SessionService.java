package com.dontwaste.service;

import com.dontwaste.model.entity.Session;
import com.dontwaste.model.entity.User;

public interface SessionService {

    void addSession(Session session);
    User getUserByToken(String token);
    void deleteSessionByToken(String token);


}
