package com.songify.domain.crud;

import com.songify.domain.crud.dto.ArtistDto;
import com.songify.domain.crud.dto.ArtistRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@AllArgsConstructor
class ArtistAdder {

    private final ArtistRepository artistRepository;

    ArtistDto addArtist(final String name) {
        Artist saved = saveArtist(name);
        return new ArtistDto(saved.getId(), saved.getName());
    }

    ArtistDto addArtistWithDefaultAlbumAndSong(final ArtistRequestDto dto) {
        String artistName = dto.name();
        Artist save = saveArtistWithDefaultAlbumAndSong(artistName);
        return new ArtistDto(save.getId(), save.getName());
    }

    private Artist saveArtistWithDefaultAlbumAndSong(final String name) {
        Artist artist = new Artist(name);
        Album album = new Album();
        album.setTitle("default-album:" + UUID.randomUUID());
        album.setReleaseDate(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        Song song = new Song("default-song-name:" + UUID.randomUUID());
        album.addSongToAlbum(song);
        artist.addAlbum(album);
        return artistRepository.save(artist);
    }

    private Artist saveArtist(final String name) {
        Artist artist = new Artist(name);
        return artistRepository.save(artist);
    }

}
