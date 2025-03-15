package com.songify.song.infrasctructure.controller.dto.response;

import java.util.List;

public record GetAllSongsResponseDto(List<SongDto> songs) {
}
