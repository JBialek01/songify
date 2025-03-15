package com.songify.song.domain.repository;

import com.songify.song.domain.model.Song;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SongRepositoryInMemory implements SongRepository {

    Map<Integer, Song> database = new HashMap<>(Map.of(
            1, new Song("Fade to black", "Metallica"),
            2, new Song("Numb", "Linkin Park"),
            3, new Song("Walk", "Pantera"),
            4, new Song("Holiday", "Green Day")
    ));

    @Override
    public Song save(Song song) {
        database.put(database.size() + 1, song);
        return song;
    }

    @Override
    public List<Song> findAll() {
        return database.values()
                .stream()
                .toList();
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateById(Long id, Song newSong) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
