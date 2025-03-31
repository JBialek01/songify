package com.songify.domain.crud.song;

import com.songify.domain.crud.song.dto.SongDto;
import com.songify.infrastructure.crud.song.controller.dto.request.CreateSongRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SongCrudFacade {

    private final SongRetriever songRetriever;
    private final SongAdder songAdder;
    private final SongDeleter songDeleter;
    private final SongUpdater songUpdater;

    public List<SongDto> findAll(final Pageable pageable) {
        return songRetriever.findAll(pageable)
                .stream()
                .map(song -> SongDto.builder()
                        .id(song.getId())
                        .name(song.getName())
                        .name(song.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public SongDto findSongDtoById(final Long id) {
        return songRetriever.findSongById(id);
    }

    public SongDto addSong(final SongDto songDto) {
        String name = songDto.name();
        Song validatedAndReadyToSaveSong = new Song(name);
        Song addedSong = songAdder.addSong(validatedAndReadyToSaveSong);
        return SongDto.builder()
                .id(addedSong.getId())
                .name(addedSong.getName())
                .build();
    }

    public void deleteById(final Long id) {
        songRetriever.existsById(id);
        songDeleter.deleteById(id);
    }

    public void updateById(final Long id, final SongDto newSongDto) {
        songRetriever.existsById(id);
        Song songValidatedAndReadyToUpdate = new Song(newSongDto.name());
        songUpdater.updateById(id, songValidatedAndReadyToUpdate);
    }

    public SongDto updatePartiallyById(final Long id, final SongDto songFromRequest) {
        songRetriever.existsById(id);
        Song songFromDatabase = songRetriever.findSongById(id);
        Song toSave = new Song();
        if (songFromRequest.name() != null) {
            toSave.setName(songFromRequest.name());
        } else {
            toSave.setName(songFromDatabase.getName());
        }
//        todo
//        if (songFromRequest.getArtist() != null) {
//            builder.artist(songFromRequest.getArtist());
//        } else {
//            builder.artist(songFromDatabase.getArtist());
//        }
        songUpdater.updateById(id, toSave);
        return SongDto.builder()
                .id(toSave.getId())
                .name(toSave.getName())
                .build();
    }
}
