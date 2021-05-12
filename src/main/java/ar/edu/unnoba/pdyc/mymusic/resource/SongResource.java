package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
=======
>>>>>>> 99b45a357848cbd051e7032cdfc3f289ba04c827

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Type;
import java.util.List;

@RequestMapping("/songs")
public class SongResource {

    private SongService songService;
    @Autowired
    private ModelMapper modelMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SongListResponseDTO> getSongs(){
        List<Song> songs = songService.getSongs();
        Type listType = new TypeToken<List<SongListResponseDTO>>() {}.getType();
        List<SongListResponseDTO> songList = modelMapper.map(songs, listType);
        return songList;
    }
}
