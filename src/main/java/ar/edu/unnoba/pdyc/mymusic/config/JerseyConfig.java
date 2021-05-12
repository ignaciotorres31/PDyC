package ar.edu.unnoba.pdyc.mymusic.config;

import ar.edu.unnoba.pdyc.mymusic.resource.SongResource;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig()
    {
        register(SongResource.class);
    }
}
