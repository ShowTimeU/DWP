package com.dontwaste.service;


import com.dontwaste.model.customer.entity.Session;
import com.dontwaste.model.customer.entity.User;
import com.dontwaste.repository.SessionRepository;
import com.dontwaste.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImp implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public void addSession(Session session) {
        sessionRepository.save(session);
    }

    @Override
    public User getUserByToken(String token) {
        Session session = sessionRepository.findByToken(token);
        return session.getUser();
    }
}
