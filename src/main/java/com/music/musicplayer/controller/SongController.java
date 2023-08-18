package com.music.musicplayer.controller;

import com.music.musicplayer.repository.SongRepository;
import com.music.musicplayer.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final StorageService storageService;
    private final SongRepository songRepository;

    @Autowired
    public SongController(StorageService storageService, SongRepository songRepository) {
        this.storageService = storageService;
        this.songRepository = songRepository;
    }

    @GetMapping
    public ResponseEntity<List<Song>> getSongs(){
        return ResponseEntity.ok(songRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable String id){
        Optional<Song> song = songRepository.findById(id);

        if(song.isPresent()){
            return ResponseEntity.ok(song.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Song> createSong(@RequestPart("song")Song song, @RequestPart("file")MultipartFile file){
        if(songRepository.exist)
    }

}
