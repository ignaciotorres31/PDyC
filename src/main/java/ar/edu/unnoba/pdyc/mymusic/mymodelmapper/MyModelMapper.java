package ar.edu.unnoba.pdyc.mymusic.mymodelmapper;

import ar.edu.unnoba.pdyc.mymusic.dto.SongCreateRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongListResponseDTO;
import ar.edu.unnoba.pdyc.mymusic.dto.SongUpdateRequestDTO;
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
        this.addMappings(configUpdateDTOToSong());
    }

    //aca va el mapeo
    private PropertyMap<Song, SongListResponseDTO> configSongToListDTO() {
    		return new PropertyMap<Song, SongListResponseDTO>() {
    			@Override
    			protected void configure() {
    			    map().setGenre(source.getGenre());
    			}
    		};
    	}

    private PropertyMap<SongCreateRequestDTO, Song> configCreateDTOToSong() {
        return new PropertyMap<SongCreateRequestDTO, Song>() {
            @Override
            protected void configure(){
            }
        };
    }

    private PropertyMap<SongUpdateRequestDTO, Song> configUpdateDTOToSong() {
        return new PropertyMap<SongUpdateRequestDTO, Song>() {
            @Override
            protected void configure(){
            }
        };
    }
}
