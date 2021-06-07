package ar.edu.unnoba.pdyc.mymusic.serviceImpl;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.UserRepository;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    SongRepository songRepository;
    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Playlist create(PlaylistCreateRequestDTO playlistCreateRequestDTO, String ownerEmail) {
        User user = userRepository.findByEmail(ownerEmail);
        Playlist playlist = playlistRepository.findByOwnerAndName(user, playlistCreateRequestDTO.getName());
        List<Song> songs = songRepository.findAllById(playlistCreateRequestDTO.getSongId());
        if (playlist != null) {
            return playlist;
        }

        Playlist newPlaylist = new Playlist();
        newPlaylist.setName(playlistCreateRequestDTO.getName());
        newPlaylist.setOwner(user);
        newPlaylist.setSongs(songs);
        return playlistRepository.save(newPlaylist);
    }

    @Override
    public List<Playlist> findAll(){
        return playlistRepository.findAll();
    }
}
