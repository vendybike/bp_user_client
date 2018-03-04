/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx;

import cz.feec.userclientfx.entity.Data;
import cz.feec.userclientfx.rest.UserRestApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author vendy
 */
public class Tester {

    UserRestApi rest;
    String id;

    public Tester(Long userId) {
        id = userId.toString();
        rest = UserRestApi.getRest();
    }

    public List<Double> testByGet() {

        List<Double> times = new ArrayList<Double>();

        if (rest.getData(id) != 200) {
            return null;
        }

        for (int i = 0; i < 10; i++) {

            double startTime = System.currentTimeMillis();

            for (int j = 0; j <= i; j++) {
                rest.getData(id);
            }

            double currentTime = (System.currentTimeMillis() - startTime) / 1000;
            times.add(currentTime);
        }
        return times;
    }

    public List<Double> testByPost() {

        Data data = createRandomData();
        List<Double> times = new ArrayList<Double>();

        if (rest.addData(id, data) != 200) {
            return null;
        }

        for (int i = 0; i < 10; i++) {

            
            double startTime = System.currentTimeMillis();
            
            for (int j = 0; j <= i; j++) {
                rest.addData(id, data);
            }

            double currentTime = (System.currentTimeMillis() - startTime) / 1000;
            times.add(currentTime);
        }

        return times;
    }
    
    private Data createRandomData(){
        
        Random rd = new Random();
        Data data = new Data();
        data.setFat(rd.nextInt());
        data.setPulse(rd.nextInt());
        data.setStress(rd.nextInt());
        
        return data;
    }

}
