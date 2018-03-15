/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx;

import cz.feec.userclientfx.entity.Data;
import cz.feec.userserver.soap.DataEntity;
import cz.feec.userserver.soap.ResourceExceptions_Exception;
import cz.feec.userserver.soap.ResourceNotFoundException_Exception;
import cz.feec.userserver.soap.UserService;
import cz.feec.userserver.soap.UserServiceService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vendy
 */
public class SoapTester {

    long id;
    UserServiceService service;
    UserService port;

    public SoapTester(long userId) {
        id = userId;
        service = new UserServiceService();
        port = service.getUserServicePort();
    }

    public List<Double> testByGet() throws ResourceNotFoundException_Exception {

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
        DataEntity data = createRandomData();
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

    private double addData(long id, DataEntity data) {
        double startTime = System.currentTimeMillis();
        try {
            port.createData(id, data);
        } catch (ResourceExceptions_Exception ex) {
            Logger.getLogger(SoapTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    private double getData(long id) throws ResourceNotFoundException_Exception {
        double startTime = System.currentTimeMillis();
        port.getData(id);
        return (System.currentTimeMillis() - startTime) / 1000;
    }

    private DataEntity createRandomData() {

        Random rd = new Random();
        DataEntity data = new DataEntity();
        data.setFat(rd.nextInt());
        data.setPulse(rd.nextInt());
        data.setStress(rd.nextInt());

        return data;
    }

}
