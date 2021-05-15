package ar.edu.unnoba.pdyc.mymusic.constant;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public enum GenreEnum {

    ROCK(1),
    TECHNO(2),
    POP(3),
    JAZZ(4),
    FOLK(5),
    CLASSICAL(6);

    public final int id;

    private GenreEnum(int id) {
        this.id = id;
    }
}
