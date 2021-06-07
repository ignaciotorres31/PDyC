package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface PlaylistService {

    Playlist create(PlaylistCreateRequestDTO playlistCreateRequestDTO, String ownerEmail);

    List<Playlist> findAll();

}
