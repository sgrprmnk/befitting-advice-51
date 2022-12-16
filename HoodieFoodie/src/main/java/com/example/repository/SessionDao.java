package com.example.repository;

import com.example.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDao extends JpaRepository<CurrentUserSession,String> {
    public CurrentUserSession findByUuid(String uuid);
}
