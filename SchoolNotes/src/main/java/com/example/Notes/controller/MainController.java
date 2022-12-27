package com.example.Notes.controller;

import com.example.Notes.model.Note;
import com.example.Notes.service.NoteService;
import com.example.Notes.util.WebUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private final NoteService noteService;
    private final WebUtil webUtil;

    @GetMapping("/")
    public String note(Model model) {
        model.addAttribute("note", new Note());
        return "main";
    }

    @GetMapping("/note")
    public String getNote(Model model) {
        List<Note> notes = noteService.findAllByIpAddress(webUtil.getClientIp());
        model.addAttribute("notes", notes);
        return "note";
    }

    @PostMapping("/")
    public String addNote(@ModelAttribute("note") Note note, Model model) {
        note.setIpAddress(webUtil.getClientIp());
        noteService.saveNote(note);
        return "redirect:/note";
    }

    @GetMapping("/note/delete")
    public String deleteNote(@RequestParam String title) {
        noteService.deleteNote(title, webUtil.getClientIp());
        return "redirect:/note";
    }
}
