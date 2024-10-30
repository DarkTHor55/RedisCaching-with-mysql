package com.basiccrud.redisAndMysql.Service;

import com.basiccrud.redisAndMysql.Entity.Notes;
import com.basiccrud.redisAndMysql.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;
    @CachePut(value = "notes",key = "#notes.id")
    public Notes createNotes(Notes notes){
        return notesRepository.save(notes);
    }
    public List<Notes>getAllNotes(){
        return notesRepository.findAll();
    }
    @Cacheable(key = "#notesId", value ="notes")
    public Notes getNotesById(String notesId){
        return notesRepository.findById(notesId).orElse(null);
    }
    @CacheEvict(value = "notes",key = "#note.id")
    public void deleteNotes(String notesId){
        notesRepository.deleteById(notesId);
    }


}
