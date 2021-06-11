package ar.edu.unnoba.pdyc.mymusic.service;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public interface PlaylistService {

    Playlist create(PlaylistCreateRequestDTO playlistCreateRequestDTO, String ownerEmail);

    List<Playlist> findAllByOwner(String ownerEmail);

    Playlist update(Long id, String name, String userEmail) throws Exception;

    Playlist addSong(Long id, Song song, String userName)throws Exception;

    Playlist removeSong(Long id, Long songId, String userName) throws Exception;

    void delete(Long id, String userName)throws Exception;
}
