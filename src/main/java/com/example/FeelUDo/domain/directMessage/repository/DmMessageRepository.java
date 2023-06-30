package com.example.FeelUDo.domain.directMessage.repository;

import com.example.FeelUDo.domain.directMessage.entity.DmMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DmMessageRepository extends JpaRepository<DmMessage, Long> {

    @Query(value = "select w from DmMessage w where w.dmRoom = :room")
    List<DmMessage> findAllByWebSocketRoom(@Param(value = "room") Long roomId);

}

