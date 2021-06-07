package ar.edu.unnoba.pdyc.mymusic.resource;


import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import ar.edu.unnoba.pdyc.mymusic.mymodelmapper.MyModelMapper;
import ar.edu.unnoba.pdyc.mymusic.service.PlaylistService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Type;
import java.util.List;

@Path("/playlists")
public class PlaylistResource {

    @Autowired
    private PlaylistService playlistService;

    private MyModelMapper modelMapper = new MyModelMapper();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylist(){
        List<Playlist> playlists = playlistService.findAll();
        Type listType = new TypeToken<List<PlaylistResponseDTO>>() {}.getType();
        List<PlaylistResponseDTO> playlist = modelMapper.map(playlists, listType);
        return Response.ok(playlist).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlaylist(PlaylistCreateRequestDTO playlistCreateRequestDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ownerEmail = (String)auth.getPrincipal();
        Playlist playlist = modelMapper.map(playlistCreateRequestDTO,Playlist.class);
        playlistService.create(playlist, ownerEmail);
        return Response.ok().build();
    }
}
