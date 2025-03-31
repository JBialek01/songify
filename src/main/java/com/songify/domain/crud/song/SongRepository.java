package com.songify.domain.crud.song;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends Repository<Song, Long> {

    @Query("select s from Song s")
    List<Song> findAll(Pageable pageable);

    @Query("select s from Song s where s.id = :id")
    Optional<Song> findById(Long id);

    @Modifying
    @Query("delete from Song s where s.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("update Song s set s.name = :#{#newSong.name}, s.artist = :#{#newSong.artist} where s.id = :id")
    void updateById(Long id, Song newSong);

    Song save(Song song);

    boolean existsById(Long id);
}

