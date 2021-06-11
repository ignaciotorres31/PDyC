package ar.edu.unnoba.pdyc.mymusic.dto;


import ar.edu.unnoba.pdyc.mymusic.model.Song;

import java.util.List;

public class PlaylistCreateRequestDTO {

    private String name;
    private List<Long> songsId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSongsId() {
        return songsId;
    }

    public void setSongsId(List<Long> songsId) {
        this.songsId = songsId;
    }
}
