package com.songify.domain.crud;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryGenreRepository implements GenreRepository {

    Map<Long, Genre> db = new HashMap<>();
    AtomicInteger index = new AtomicInteger(1);

    public InMemoryGenreRepository() {
        save(new Genre(1L, "default"));
    }

    @Override
    public Genre save(final Genre genre) {
        long index = this.index.getAndIncrement();
        db.put(index, genre);
        genre.setId(index);
        return genre;
    }

    @Override
    public Optional<Genre> findById(final Long id) {
        Genre value = db.get(id);
        return Optional.ofNullable(value);
    }

    @Override
    public Set<Genre> findAll() {
        return new HashSet<>(db.values());
    }

    @Override
    public int deleteById(final Long id) {
        return 0;
    }
}
