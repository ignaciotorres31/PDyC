package ar.edu.unnoba.pdyc.mymusic.serviceImpl;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import ar.edu.unnoba.pdyc.mymusic.repository.PlaylistRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.UserRepository;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {


    @Autowired
    PlaylistRepository playlistRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void create(Playlist playlist, String ownerEmail) {
        User user = userRepository.findByEmail(ownerEmail);
        playlist.setOwner(user);
        playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> findAll(){
        return playlistRepository.findAll();
    }
}
