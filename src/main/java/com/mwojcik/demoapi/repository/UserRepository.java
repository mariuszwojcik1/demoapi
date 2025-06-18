package com.mwojcik.demoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mwojcik.demoapi.model.User;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  User findByLogin(String login);
  
}
