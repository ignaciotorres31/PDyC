package ar.edu.unnoba.pdyc.mymusic.serviceImpl;

import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {


    @Qualifier("songRepository")
    @Autowired
    SongRepository songRepository;

    @Override
    public List<Song> getSongs(){
        return songRepository.findAll();
    }


}
