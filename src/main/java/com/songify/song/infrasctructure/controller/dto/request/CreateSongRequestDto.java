package com.songify.song.infrasctructure.controller.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateSongRequestDto(
        @NotNull(message = "name must not be null")
        @NotEmpty(message = "name must not be empty")
        String songName,

        @NotNull(message = "artist must not be null")
        @NotEmpty(message = "artist must not be empty")
        String artist
) {
}
