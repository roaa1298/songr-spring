package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/addSong/{id}")
    public String addSongForm(@PathVariable Long id,Model m){
        m.addAttribute("albumId",id);
        return "addSong";
    }

    @PostMapping("/addSong/{id}")
    public RedirectView addSong(String title , int length, int trackNumber , @PathVariable Long id) {
        Album album = albumRepository.findById(id).orElseThrow();
        Song song = new Song(title,length,trackNumber,album);
        songRepository.save(song);
        return new RedirectView("/albums/"+id+"/songs");
    }

    @GetMapping("/songs")
    public String getAllSongs(Model model){
        model.addAttribute("songsList",songRepository.findAll());
        return "songs";
    }

}
