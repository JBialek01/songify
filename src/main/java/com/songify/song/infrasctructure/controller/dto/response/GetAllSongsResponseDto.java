package com.songify.song.infrasctructure.controller.dto.response;

import com.songify.song.domain.model.Song;

import java.util.List;
import java.util.Map;

public record GetAllSongsResponseDto(List<Song> songs) {
}
