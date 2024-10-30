package com.basiccrud.redisAndMysql.Controller;

import com.basiccrud.redisAndMysql.Entity.Notes;
import com.basiccrud.redisAndMysql.Service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/notes")
public class NotesController {
    @Autowired
    private NotesService notesService;
    @PostMapping("/create")
    public String createNotes(@RequestBody Notes notes) {
        notes.setId(UUID.randomUUID().toString());
        notesService.createNotes(notes);
        return "Notes created successfully";
    }
    @GetMapping
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }
    @GetMapping("/get/{notesId}")
    public Notes getNotesById(@PathVariable String notesId){
        return notesService.getNotesById(notesId);
    }
    @DeleteMapping("/delete/{notesId}")
    public String deleteNotes(@PathVariable String notesId){
        notesService.deleteNotes(notesId);
        return "Notes deleted successfully";
    }
}
