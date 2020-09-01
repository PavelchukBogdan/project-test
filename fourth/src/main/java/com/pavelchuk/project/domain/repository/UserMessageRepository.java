package com.pavelchuk.project.domain.repository;

import com.pavelchuk.project.domain.entity.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMessageRepository extends JpaRepository<UserMessage,Long> {
    @Query("select m from UserMessage m where m.timestamp between ?1 and ?2 ")
    List<UserMessage> findAllMessagesByInterval(Long from, Long to);
}
