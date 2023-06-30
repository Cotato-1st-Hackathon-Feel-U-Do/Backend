package com.example.FeelUDo.domain.sideDish.repository;

import com.example.FeelUDo.domain.sideDish.entity.SideDish;
import com.example.FeelUDo.domain.sideDish.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
