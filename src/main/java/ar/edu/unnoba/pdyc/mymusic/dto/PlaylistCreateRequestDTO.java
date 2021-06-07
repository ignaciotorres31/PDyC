package ar.edu.unnoba.pdyc.mymusic.dto;


import java.util.List;

public class PlaylistCreateRequestDTO {

    private String name;
    private List<Long> songId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSongId() {
        return songId;
    }

    public void setSongId(List<Long> songId) {
        this.songId = songId;
    }
}
