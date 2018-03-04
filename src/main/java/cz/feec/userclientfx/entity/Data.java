/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.entity;

/**
 *
 * @author vendy
 */
public class Data {
    
    private double pulse;
    private double stress;
    private double fat;
    private double weight;

    public double getPulse() {
        return pulse;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public double getStress() {
        return stress;
    }

    public void setStress(double stress) {
        this.stress = stress;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getWeight() {
        return weight;
    }
}
