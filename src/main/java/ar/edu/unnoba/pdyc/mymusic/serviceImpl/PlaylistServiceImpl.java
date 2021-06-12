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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
        List<Song> songs = songRepository.findAllById(playlistCreateRequestDTO.getSongsId());

        Playlist newPlaylist = new Playlist();
        newPlaylist.setName(playlistCreateRequestDTO.getName());
        newPlaylist.setOwner(user);
        newPlaylist.setSongs(songs);
        return playlistRepository.save(newPlaylist);
    }

    @Override
    public List<Playlist> findAllByOwner(String ownerEmail){
        User user = userRepository.findByEmail(ownerEmail);
        return playlistRepository.findByOwner(user);
    }

    @Override
    @Transactional
    public Playlist update(Long id, String name, String userEmail) throws Exception {
        Playlist p = playlistRepository.findById(id).get();
        if (!p.getOwner().getEmail().equals(userEmail)) {
            throw new Exception();
        }
        p.setName(name);
        return playlistRepository.save(p);
    }

    @Override
    @Transactional
    public Playlist addSong(Long id, Song song, String userEmail) throws Exception {
        Playlist playlist = playlistRepository.findById(id).get();
        if (!playlist.getOwner().getEmail().equals(userEmail)) {
            throw new Exception();
        }
        song = songRepository.findById(song.getId()).get();
        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);
    }

    @Override
    @Transactional
    public Playlist removeSong(Long id, Long songId, String userEmail) throws Exception {
        Playlist playlist = playlistRepository.findById(id).get();
        if (!playlist.getOwner().getEmail().equals(userEmail)) {
            throw new Exception();
        }
        Song song = songRepository.findById(songId).get();

        playlist.getSongs().remove(song);
        return playlistRepository.save(playlist);
    }

    @Override
    public void delete(Long id, String userEmail) throws Exception {
        Playlist playlist = playlistRepository.findById(id).get();
        if (!playlist.getOwner().getEmail().equals(userEmail)) {
            throw new Exception();
        }
        playlistRepository.deleteById(id);
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<Playlist>> getPlaylistsAsync(String ownerEmail) throws Exception{
        User user = userRepository.findByEmail(ownerEmail);
        return CompletableFuture.completedFuture(playlistRepository.findByOwner(user));
    }
}
