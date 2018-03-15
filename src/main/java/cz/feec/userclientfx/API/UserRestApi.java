/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.API;

import cz.feec.userclientfx.exceptions.ResourceExceptions;
import cz.feec.userclientfx.entity.Data;
import cz.feec.userclientfx.entity.User;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author vendy
 */
public class UserRestApi {

    private UserRestApi() {
    }

    private static volatile UserRestApi rest = null;

    public static UserRestApi getRest() {
        if (rest == null) {
            synchronized (UserRestApi.class) {
                if (rest == null) {
                    rest = new UserRestApi();
                }
            }
        }
        return rest;
    }

    public int postUser(User user) throws ResourceExceptions {
        System.out.println(user.getPassword());
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/users/");
        Response response;
        int status = 0;
        try {
            response = (Response) target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
            status = response.getStatus();
            response.close();
        } catch (RuntimeException e) {
            throw new ResourceExceptions.BadConnectionException();
        }

        if (status == 409) {
            throw new ResourceExceptions.EmailAlreadyExistException();
        } else if (status == 400) {
            throw new ResourceExceptions.BadRequestException();
        }

        return status;
    }

    public User getUser() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/users/1");
        Response response = (Response) target.request().get();
        if (response.getStatus() != 200) {
            return null;
        }
        User user = response.readEntity(User.class);
        System.out.println("Email: " + user.getEmail());
        response.close();
        return user;
    }

    public User getUser(String userEmail) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/users/search?email=" + userEmail);
        Response response = (Response) target.request().get();
        if (response.getStatus() != 200) {
            return null;
        }
        User user = response.readEntity(User.class);
        System.out.println("Email: " + user.getEmail());
        response.close();
        return user;
    }

    public int addData(String path, Data data) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/Dates/" + path);
        Response response = (Response) target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
        int status = response.getStatus();
        response.close();
        return status;
    }

    public int getData(String path) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/Dates/" + path);
        Response response = (Response) target.request().get();
        int status = response.getStatus();
        response.close();
        return status;
    }
}
