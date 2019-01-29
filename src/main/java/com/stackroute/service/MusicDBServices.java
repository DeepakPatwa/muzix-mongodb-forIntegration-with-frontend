package com.stackroute.service;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackDoesNotExists;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicDBServices implements MusicServices{

    @Autowired
    private MusicRepository musicRepository;
    public MusicDBServices(MusicRepository musicRepository) {
        this.musicRepository= musicRepository;
    }

    public void setTrackRepository(MusicRepository musicRepository) {

        this.musicRepository = musicRepository;
    }


    public MusicTrack saveTrack(MusicTrack musicTrack) throws TrackAlreadyExistsException
    {
        if(musicRepository.existsById(musicTrack.getId()))
        {
            throw new TrackAlreadyExistsException("User Already Exists");
        }

        MusicTrack musicTrack1=musicRepository.save(musicTrack);

        if(musicTrack1==null)
            throw new TrackAlreadyExistsException("User Already Exists");

        return musicTrack1;
    }

    public List<MusicTrack> getAllTracks() {
        List<MusicTrack> trackList = (List<MusicTrack>)musicRepository.findAll();
        return trackList;
    }

    public MusicTrack updateTrack(String id, String comment) throws TrackDoesNotExists{
        if(!musicRepository.existsById(id))
        {
            throw new TrackDoesNotExists("no such Track exists");
        }

        MusicTrack musicTrack=musicRepository.findById(id);
        if (musicTrack==null)
        {
            throw new TrackDoesNotExists("no such Track exists");
        }
        musicTrack.setComment(comment);

        return musicRepository.save(musicTrack);
    }

//    public MusicTrack updateTrack(MusicTrack musicTrack) throws TrackDoesNotExists {
//        if(!musicRepository.existsById(musicTrack.getId()))
//        {
//            throw new TrackDoesNotExists("no such Track exists");
//        }
//        MusicTrack musicTrack1=musicRepository.save(musicTrack);
//        if (musicTrack1==null)
//        {
//            throw new TrackDoesNotExists("no such Track exists");
//        }
//        return musicTrack1;
//    }

    public void deleteTrack(String id) throws TrackDoesNotExists{

        if(musicRepository.existsById(id)==false)
        {
            throw new TrackDoesNotExists("no such Track exists");
        }

        musicRepository.deleteById(id);
    }
}
