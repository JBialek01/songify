package com.songify.domain.crud;

import com.songify.domain.crud.dto.AlbumInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

interface AlbumRepository extends Repository<Album, Long> {

    Album save(final Album album);

    Optional<Album> findById(Long id);

    Set<Album> findAll();

    @Query("""
            select a from Album a
            join fetch a.songs songs
            join fetch a.artists artists
            where a.id = :id""")
    Optional<AlbumInfo> findAlbumByIdWithSongsAndArtists(Long id);

    @Query("""
            select a from Album a 
            inner join a.artists artists 
            where artists.id = :id
            """)
    Set<Album> findAllAlbumsByArtistId(@Param("id") Long id);

    @Modifying
    @Query("delete from Album a where a.id in :ids")
    int deleteByIdIn(Collection<Long> ids);
}
