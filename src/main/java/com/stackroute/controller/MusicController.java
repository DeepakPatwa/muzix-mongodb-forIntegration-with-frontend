package com.stackroute.controller;


        import com.stackroute.domain.MusicTrack;
        import com.stackroute.exceptions.TrackDoesNotExists;
        import com.stackroute.exceptions.TrackAlreadyExistsException;
        import com.stackroute.service.MusicServices;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("muzix/v1/")
public class MusicController {


    private MusicServices musicServices;

    @Autowired
    public MusicController(MusicServices musicServices) {
        this.musicServices =musicServices;
    }

    public void setTrackService(MusicServices musicServices) {
        this.musicServices =musicServices;
    }

    @RequestMapping(value = "insertTrack", method = RequestMethod.POST)
    public ResponseEntity<MusicTrack> saveTrack(@RequestBody MusicTrack musicTrack){
        ResponseEntity<MusicTrack> responseEntity;
        try {
            MusicTrack musicTrack1 = musicServices.saveTrack(musicTrack);
            responseEntity=new ResponseEntity<MusicTrack>(musicTrack1 , HttpStatus.OK);
        }
        catch (TrackAlreadyExistsException ex)
        {
            responseEntity=new ResponseEntity<MusicTrack>(musicTrack , HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(value = "updateTrack/{id}/{comment}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrack(@PathVariable String id, @PathVariable String comment){
        ResponseEntity<String> responseEntity;
        try{
            MusicTrack track2 = musicServices.updateTrack(id, comment);
            responseEntity=new ResponseEntity<String>("Updated Sucssfully" , HttpStatus.OK);
        }
        catch (TrackDoesNotExists ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage() , HttpStatus.CONFLICT);
        }
        return responseEntity;

    }

//    @RequestMapping(value = "update", method = RequestMethod.PUT)
//    public ResponseEntity<String> updateTrack(@RequestBody MusicTrack musicTrack){
//        ResponseEntity<String> responseEntity;
//        try {
//            MusicTrack musicTrack1 = musicServices.updateTrack(musicTrack);
//            responseEntity=new ResponseEntity<String>("Updated Sucssfully" , HttpStatus.OK);
//        }
//        catch (TrackDoesNotExists ex)
//        {
//            responseEntity=new ResponseEntity<String>(ex.getMessage() , HttpStatus.CONFLICT);
//        }
//        return responseEntity;
//    }

    @RequestMapping(value = "deleteTrack/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrack(@PathVariable("id") String id){
        ResponseEntity responseEntity;

        try {
            responseEntity=new ResponseEntity<String>("Deleted Sucessfully" , HttpStatus.OK);
            musicServices.deleteTrack(id);
        }
        catch(TrackDoesNotExists ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage() , HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping(value = "tracks", method = RequestMethod.GET)
    public ResponseEntity<List<MusicTrack>> listOfUsers() {
        List<MusicTrack> allUsers = musicServices.getAllTracks();
        return new ResponseEntity<List<MusicTrack>>(allUsers, HttpStatus.OK);
    }
}