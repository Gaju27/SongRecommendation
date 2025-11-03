package com.online.lyrics.controller;

import com.online.lyrics.model.dto.BulkSongRequest;
import com.online.lyrics.model.dto.BulkSongResponse;
import com.online.lyrics.service.SongEmbeddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/songs/v1/embeddings")
public class EmbeddingsController {

    @Autowired
    SongEmbeddingService songEmbeddingService;


    @PostMapping("/bulk")
    ResponseEntity<BulkSongResponse> createEmbeddingFromBulkSong(@RequestBody BulkSongRequest request) {
        return new ResponseEntity<>(songEmbeddingService.createEmbeddingFromBulkSong(request), HttpStatus.CREATED);
    }
}


