package com.songify.song.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record SongRequestDto(
        @NotNull(message = "Song name must not be null")
        @NotEmpty(message = "Song name must not be empty")
        String songName
) {
}
