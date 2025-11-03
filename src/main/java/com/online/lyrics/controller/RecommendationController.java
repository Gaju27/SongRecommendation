package com.online.lyrics.controller;

import com.online.lyrics.model.dto.MusicRequest;
import com.online.lyrics.model.dto.SongRecommendationResponse;
import com.online.lyrics.service.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/songs/v1/recommendations")
public class RecommendationController {

    @Autowired
    RecommendationService recommendationService;
    Logger logger = LoggerFactory.getLogger(RecommendationController.class);

    @PostMapping
    public ResponseEntity<List<SongRecommendationResponse>> recommendSongs(
            @RequestBody MusicRequest request) {

        List<SongRecommendationResponse> recommendations = recommendationService.recommendSongs(
                request.mood(),
                request.limit() != null ? request.limit() : 10
        );
        return ResponseEntity.ok(recommendations);
    }
}