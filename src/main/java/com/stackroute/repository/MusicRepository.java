package com.stackroute.repository;

import com.stackroute.domain.MusicTrack;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository  extends MongoRepository<MusicTrack, Integer> {
//
//    public MusicTrack save(MusicTrack musicTrack);
//
   public void deleteById(String id);
//
//    public List<MusicTrack> findAll();

    public boolean existsById(String id);

    public MusicTrack findById(String id);
}
