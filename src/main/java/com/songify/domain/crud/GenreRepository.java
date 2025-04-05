package com.songify.domain.crud;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

interface GenreRepository extends Repository<Genre, Long> {

    Genre save(Genre genre);

    @Transactional
    @Modifying
    @Query("delete from Genre g where g.id = :id")
    int deleteById(Long id);
}
