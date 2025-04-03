package com.songify.domain.crud;

import com.songify.domain.crud.dto.AlbumInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Optional;

interface AlbumRepository extends Repository<Album, Long> {

    Album save(final Album album);

    Optional<Album> findById(Long id);

    @Query("""
            select a from Album a
            join fetch a.songs songs
            join fetch a.artists artists
            where a.id = :id""")
    Optional<AlbumInfo> findAlbumByIdWithSongsAndArtists(Long id);
}
