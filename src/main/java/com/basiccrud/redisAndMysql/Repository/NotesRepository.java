package com.basiccrud.redisAndMysql.Repository;

import com.basiccrud.redisAndMysql.Entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes,String>{

}
