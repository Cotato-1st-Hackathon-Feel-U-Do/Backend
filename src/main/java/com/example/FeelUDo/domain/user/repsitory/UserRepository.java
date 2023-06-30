package com.example.FeelUDo.domain.user.repsitory;

import com.example.FeelUDo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
