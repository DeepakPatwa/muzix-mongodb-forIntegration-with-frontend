package com.stackroute.service;

import com.stackroute.domain.MusicTrack;
import com.stackroute.exceptions.TrackDoesNotExists;
import com.stackroute.exceptions.TrackAlreadyExistsException;

import java.util.List;

public interface MusicServices {
    public MusicTrack saveTrack(MusicTrack musicTrack) throws TrackAlreadyExistsException;

    public List<MusicTrack> getAllTracks();

    public MusicTrack updateTrack(String id, String comment) throws TrackDoesNotExists;

//    public MusicTrack updateTrack(MusicTrack musicTrack) throws TrackDoesNotExists;

    public void deleteTrack(String id) throws TrackDoesNotExists;
}
