/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx;

import cz.feec.userclientfx.entity.Data;
import cz.feec.userclientfx.API.UserRestApi;
import cz.feec.userclientfx.entity.User;
import cz.feec.userclientfx.exceptions.ResourceExceptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.control.Alert;
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
public class RestTester {

    UserRestApi rest;
    String id;

    public RestTester(Long userId) {
        id = userId.toString();
        rest = UserRestApi.getRest();
    }

    public List<Double> testByGet() {

        List<Double> times = new ArrayList<Double>();
        double currentTime = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                currentTime += getData(id);
            }
            times.add(currentTime);
            currentTime = 0;
        }
        return times;
    }

    public List<Double> testByPost() {
        Data data = createRandomData();
        List<Double> times = new ArrayList<Double>();
        double currentTime = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                currentTime += addData(id, data);
            }
            times.add(currentTime);
            currentTime = 0;
        }
        return times;
    }

    private Data createRandomData() {

        Random rd = new Random();
        Data data = new Data();
        data.setFat(rd.nextInt());
        data.setPulse(rd.nextInt());
        data.setStress(rd.nextInt());

        return data;
    }

    public double addData(String path, Data data) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/Dates/" + path);
        double startTime = System.currentTimeMillis();
        Response response = (Response) target.request().post(Entity.entity(data, MediaType.APPLICATION_JSON));
        double time = (System.currentTimeMillis() - startTime) / 1000;
        int status = response.getStatus();
        response.close();
        return time;
    }

    public double getData(String path) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8888/UserServer-1.0/webresources/Dates/" + path);
        double startTime = System.currentTimeMillis();
        Response response = (Response) target.request().get();
        double time = (System.currentTimeMillis() - startTime) / 1000;
        int status = response.getStatus();
        response.close();
        return time;
    }

}
