package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;


//    @ResponseBody
//    @GetMapping("/albums")
//    public String getAlbums(Model model){
//        Album album1 = new Album("For life", "EXO",10,  350, "https://en.wikipedia.org/wiki/For_Life_(EP)#/media/File:For_Life_EP_Poster.jpg");
//        Album album2 = new Album("Blue", "Joni Mitchell", 4,  407, "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/artistic-album-cover-design-template-d12ef0296af80b58363dc0deef077ecc_screen.jpg?ts=1561488440");
//        Album album3 = new Album("Dynamite","BTS", 8,  350,"https://en.wikipedia.org/wiki/Dynamite_(BTS_song)#/media/File:BTS_-_Dynamite_(official_cover).png");
//        List<Album> albums = new ArrayList<>() ;
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        albumRepository.save(album1);
//        albumRepository.save(album2);
//        albumRepository.save(album3);
//        model.addAttribute("albums",albumRepository.findAll());
//        return "album";
//    }

    @GetMapping("/addAlbum")
    public String addAlbumForm(){
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album) {
        System.out.println(album);
        albumRepository.save(album);
        return new RedirectView("albums");
    }

    @GetMapping("/albums")
    public String getAllAlbums(Model model){
        model.addAttribute("albumsList",albumRepository.findAll());
        return "album";
    }

    @PostMapping("/albums")
    public RedirectView addSongWithId(Long id){

        return new RedirectView("/addSong/"+id);
    }

    @GetMapping("/albums/{id}/songs")
    public String viewAlbumSongs(@PathVariable Long id, Model model){
        Album album = albumRepository.findById(id).orElseThrow();
        model.addAttribute("songs", album.getSongs());
        model.addAttribute("album", album);
        return "albumInfo";
    }



}
