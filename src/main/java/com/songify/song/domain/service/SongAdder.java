package com.songify.song.domain.service;

import com.songify.song.domain.model.Song;
import com.songify.song.domain.repository.SongRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
@Transactional
public class SongAdder {

    private final SongRepository songRepository;

    public Song addSong(Song song) {
        log.info("adding new song: " + song);
        return songRepository.save(song);
    }
}
