package com.example.Notes.repository;

import com.example.Notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByIpAddress(String addressIp);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Note  WHERE  title =?1 AND ip_address =?2", nativeQuery = true)
    void deleteNoteByTitleAndIpAddress(String title, String ipAddress);
}
