package com.example.FeelUDo.domain.user.repsitory;

import com.example.FeelUDo.domain.user.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
