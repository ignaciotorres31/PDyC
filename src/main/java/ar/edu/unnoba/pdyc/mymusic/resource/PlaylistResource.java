package ar.edu.unnoba.pdyc.mymusic.resource;


import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
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
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaylist(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ownerEmail = (String) auth.getPrincipal();
        List<Playlist> playlists = playlistService.findAllByOwner(ownerEmail);
        Type listType = new TypeToken<List<PlaylistResponseDTO>>() {}.getType();
        List<PlaylistResponseDTO> playlist = modelMapper.map(playlists, listType);
        return Response.ok(playlist).build();
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlaylist(PlaylistCreateRequestDTO playlistCreateRequestDTO){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String ownerEmail = (String) auth.getPrincipal();
        Playlist playlist = playlistService.create(playlistCreateRequestDTO, ownerEmail);
        PlaylistResponseDTO playlistResponseDTO = modelMapper.map(playlist,PlaylistResponseDTO.class);
        return Response.ok(playlistResponseDTO).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePlaylist(@PathParam("id") Long id, String name) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        try {
            playlistService.update(id, name, userName);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @POST
    @Path("/{id}/add-song")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addSong(@PathParam("id") Long id, SongListResponseDTO songDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        Song song = modelMapper.map(songDTO, Song.class);
        try {
            Playlist playlist = playlistService.addSong(id, song, userName);
            PlaylistResponseDTO playlistResponseDTO = modelMapper.map(playlist, PlaylistResponseDTO.class);
            return Response.ok(playlistResponseDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @DELETE
    @Path("/{id}/playlists-songs/{song_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeSong(@PathParam("id") Long id, @PathParam("song_id") Long songId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        try {
            Playlist playlist = playlistService.removeSong(id, songId, userName);
            PlaylistResponseDTO playlistResponseDTO = modelMapper.map(playlist, PlaylistResponseDTO.class);
            return Response.ok(playlistResponseDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletePlaylist(@PathParam("id") Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = (String) auth.getPrincipal();
        try {
            playlistService.delete(id, userName);
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok().build();
    }

}
