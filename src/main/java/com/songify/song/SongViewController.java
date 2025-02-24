package com.songify.song;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SongViewController {

    Map<Integer, String> database = new HashMap<>(Map.of(
            1, "Shawn Mendes - Stitches",
            2, "Ariana Grande - 7 rings",
            3, "Billie Eilish - bad guy",
            4, "Ed Sheeran - Shape of You"
    ));

    @GetMapping("/")
    public String home() {
        return "home.html";
    }

    @GetMapping("/view/songs")
    public String viewSongs(Model model) {
        model.addAttribute("songMap", database);
        return "songs.html";
    }
}
