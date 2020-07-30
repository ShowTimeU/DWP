package com.dontwaste.service;


import com.dontwaste.model.entity.Session;
import com.dontwaste.model.entity.User;
import com.dontwaste.repository.SessionRepository;
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

    @Override
    public void deleteSessionByToken(String token) {
        sessionRepository.deleteByToken(token);
    }
}
