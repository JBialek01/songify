package com.songify.song.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Objects;

@Builder
@Entity
@Getter
@Setter
@Table(name = "song")
@NoArgsConstructor
@AllArgsConstructor
public class Song extends BaseEntity {

    @Id
    @GeneratedValue(generator = "song_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "song_id_seq", sequenceName = "song_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String artist;

    Instant releaseDate;

    Long duration;

    @Enumerated(EnumType.STRING)
    SongLanguage language;

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }
}
