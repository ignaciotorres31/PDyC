package ar.edu.unnoba.pdyc.mymusic;

import ar.edu.unnoba.pdyc.mymusic.model.Playlist;
import ar.edu.unnoba.pdyc.mymusic.resource.PlaylistResource;
import ar.edu.unnoba.pdyc.mymusic.resource.SongResource;
import ar.edu.unnoba.pdyc.mymusic.resource.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(SongResource.class);
        register(PlaylistResource.class);
        register(UserResource.class);
    }
}