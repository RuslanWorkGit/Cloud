package com.example.Notes.service;

import com.example.Notes.model.Note;
import com.example.Notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> findAllByIpAddress(String ipAddress) {
        return noteRepository.findAllByIpAddress(ipAddress);
    }

    public void deleteNote(String title, String clientIp) {
        noteRepository.deleteNoteByTitleAndIpAddress(title, clientIp);
    }
    public List<Note> findAll(){
        return noteRepository.findAll();
    }
}
