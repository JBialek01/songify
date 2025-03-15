package com.songify.song.domain.service;

import com.songify.song.domain.repository.SongRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class SongDeleter {

    private final SongRepository songRepository;
    private final SongRetriever songRetriever;

    public void deleteById(Long id) {
        songRetriever.existsById(id);
        log.info("Deleting song by id: " + id);
        songRepository.deleteById(id);
    }
}
