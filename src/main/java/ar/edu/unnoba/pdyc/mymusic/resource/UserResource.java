package ar.edu.unnoba.pdyc.mymusic.resource;

import ar.edu.unnoba.pdyc.mymusic.dto.AuthenticationRequestDTO;
import ar.edu.unnoba.pdyc.mymusic.model.User;
import ar.edu.unnoba.pdyc.mymusic.mymodelmapper.MyModelMapper;
import ar.edu.unnoba.pdyc.mymusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

    @Autowired
    UserService userService;

    private MyModelMapper modelMapper = new MyModelMapper();

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response singUpUser(AuthenticationRequestDTO authenticationRequestDTO) {
        User user = modelMapper.map(authenticationRequestDTO, User.class);
        try {
            userService.create(user);
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        return Response.ok().build();
    }
}
