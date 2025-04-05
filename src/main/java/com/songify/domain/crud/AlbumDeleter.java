package com.songify.domain.crud;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
class AlbumDeleter {

    private final AlbumRepository albumRepository;

    void deleteAllAlbumsById(final Set<Long> albumIdsToDelete) {
        albumRepository.deleteByIdIn(albumIdsToDelete);
    }
}
