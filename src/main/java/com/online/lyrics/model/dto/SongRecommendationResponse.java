package com.online.lyrics.model.dto;

public record SongRecommendationResponse(String title, String artist, String album, String genre, Integer releaseYear, String motivation) {
}