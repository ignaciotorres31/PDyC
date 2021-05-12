package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SongService {

    public List<Song> getSongs();
}
