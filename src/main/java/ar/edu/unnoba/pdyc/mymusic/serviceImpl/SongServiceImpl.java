package ar.edu.unnoba.pdyc.mymusic.serviceImpl;

import ar.edu.unnoba.pdyc.mymusic.model.Genre;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import ar.edu.unnoba.pdyc.mymusic.repository.UserRepository;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    SongRepository songRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Song> getSongs(String author, String genre){
        return songRepository.findByAuthorAndGenre(author, Genre.valueOf(genre));
    }

    @Override
    @Async("taskExecutor")
    public CompletableFuture<List<Song>> getSongsAsinc(String author, String genre) {
        List<Song> songList = songRepository.findByAuthorAndGenre(author, Genre.valueOf(genre));
        return CompletableFuture.completedFuture(songRepository.findByAuthorAndGenre(author, Genre.valueOf(genre)));
    }

    @Override
    public void create(Song song, String ownerEmail) {
        User user = userRepository.findByEmail(ownerEmail);
        song.setOwner(user);
        songRepository.save(song);
    }

    @Override
    public void update(Long id, Song song, String userEmail) throws Exception {
        User user = userRepository.findByEmail(userEmail);
        Song songDB = songRepository.findById(id).get();

        if(songDB.getOwner().equals(user)){
            songDB.setGenre(song.getGenre());
            songDB.setAuthor(song.getAuthor());
            songDB.setName(song.getName());
            songRepository.save(songDB);
        }else {
            throw new Exception();
        }
    }

    @Override
    public void delete(Long id, String userEmail) throws Exception {
        User user = userRepository.findByEmail(userEmail);
        Song songDB = songRepository.findById(id).get();
        if (songDB.getOwner().equals(user)) {
            songRepository.deleteById(id);
        } else {
            throw new Exception();
        }
    }
}
