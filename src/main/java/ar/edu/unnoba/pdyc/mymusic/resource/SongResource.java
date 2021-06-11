package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.SongCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.mymodelmapper.MyModelMapper;
import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.service.SongService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.*;
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
    public  Response getSongs(@QueryParam("author") String author, @QueryParam("genre") String genre){
        List<Song> songs = songService.getSongs(author, genre);
        Type listType = new TypeToken<List<SongListResponseDTO>>() {}.getType();
        List<SongListResponseDTO> songList = modelMapper.map(songs, listType);
        return Response.ok(songList).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSong(SongCreateRequestDTO songCreateDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ownerEmail = (String)auth.getPrincipal();
        ModelMapper modelMapper2 = new ModelMapper();
        Song song = modelMapper2.map(songCreateDTO,Song.class);
        songService.create(song, ownerEmail);
        return Response.ok().build();
    }

    @PUT
    @Path("/modificar/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSong(@PathParam("id") Long id, SongCreateRequestDTO songUpdateDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = (String)auth.getPrincipal();
        Song song = modelMapper.map(songUpdateDTO,Song.class);
        try{
            songService.update(id,song, userEmail);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteSong(@PathParam("id") Long id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = (String)auth.getPrincipal();
        try{
            songService.delete(id, userEmail);
            return Response.ok().build();
        }catch (Exception e){
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

}
