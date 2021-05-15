package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.mymodelmapper.MyModelMapper;
import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/songs")
public class SongResource {

    @Autowired
    private SongService songService;

    private MyModelMapper modelMapper = new MyModelMapper();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public  List<SongListResponseDTO> getSongs(){
        List<Song> songs = songService.getSongs();
        Type listType = new TypeToken<List<SongListResponseDTO>>() {}.getType();
        List<SongListResponseDTO> songList = modelMapper.map(songs, listType);
        return songList;
    }
}
