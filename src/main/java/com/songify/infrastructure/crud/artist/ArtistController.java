package com.songify.infrastructure.crud.artist;

import com.songify.domain.crud.SongifyCrudFacade;
import com.songify.domain.crud.dto.ArtistDto;
import com.songify.domain.crud.dto.ArtistRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/artists")
class ArtistController {

    private final SongifyCrudFacade songifyCrudFacade;

    @PostMapping
    ResponseEntity<ArtistDto> postArtist(@RequestBody ArtistRequestDto artistRequestDto) {
        ArtistDto artistDto = songifyCrudFacade.addArtist(artistRequestDto);
        return ResponseEntity.ok(artistDto);
    }

    @GetMapping
    ResponseEntity<AllArtistsDto> getArtists(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Set<ArtistDto> artists = songifyCrudFacade.findAllArtists(pageable);
        AllArtistsDto allArtistsDto = new AllArtistsDto(artists);
        return ResponseEntity.ok(allArtistsDto);
    }

    @DeleteMapping("/{artistId}")
    ResponseEntity<String> deleteArtistWithAllAlbumsAndSongs(@PathVariable Long artistId) {
        songifyCrudFacade.deleteArtistByIdWithAlbumsAndSongs(artistId);
        return ResponseEntity.ok("Artist with id: " + artistId + " deleted");
    }
}
