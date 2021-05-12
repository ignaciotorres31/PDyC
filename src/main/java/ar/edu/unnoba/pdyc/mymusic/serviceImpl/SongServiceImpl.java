package ar.edu.unnoba.pdyc.mymusic.serviceImpl;

import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.repository.SongRepository;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;

    @Override
    public List<Song> getSongs(){
        return songRepository.findAll();
    }


}
