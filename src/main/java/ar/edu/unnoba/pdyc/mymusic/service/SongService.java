package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SongService {

    List<Song> getSongs(String author, String genre);

    void create(Song song, String ownerEmail);

    void update(Long id, Song song, String userEmail) throws Exception;

    void delete(Long id, String userEmail) throws Exception;
}
