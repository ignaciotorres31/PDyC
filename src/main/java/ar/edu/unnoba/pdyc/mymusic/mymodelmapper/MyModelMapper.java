package ar.edu.unnoba.pdyc.mymusic.mymodelmapper;

import ar.edu.unnoba.pdyc.mymusic.dto.PlaylistResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.model.Song;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class MyModelMapper extends ModelMapper {

    public MyModelMapper() {
        setConfiguracionGlobal();
    }

    private void setConfiguracionGlobal() {
        //aca adentro van los addMappings(name());
        this.addMappings(configSongToListDTO());
        this.addMappings(configCreateDTOToSong());
        this.addMappings(configPlaylistToPlaylistDTO());
    }

    //aca va el mapeo
    private PropertyMap<Song, SongListResponseDTO> configSongToListDTO() {
    		return new PropertyMap<Song, SongListResponseDTO>() {
    			@Override
    			protected void configure() {
    			}
    		};
    	}

    private PropertyMap<SongCreateRequestDTO, Song> configCreateDTOToSong() {
        return new PropertyMap<SongCreateRequestDTO, Song>() {
            @Override
            protected void configure(){
                map().setGenre(source.getGenre());
                map().setAuthor(source.getAuthor());
                map().setName(source.getName());
            }
        };
    }

    private PropertyMap<Playlist, PlaylistResponseDTO> configPlaylistToPlaylistDTO() {
        return new PropertyMap<Playlist, PlaylistResponseDTO>() {
            @Override
            protected void configure(){
                map().setUserId(source.getOwner());
            }
        };
    }
}
