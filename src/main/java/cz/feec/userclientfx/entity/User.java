/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.feec.userclientfx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author vendy
 */
@JsonIgnoreProperties(ignoreUnknown = true, value =  {"data", "role"})
public class User {
    
    protected long id;
    protected String email;
    protected String password;
    protected int age;
    protected String workPosition;
    protected List<Data>data;
    // private Data data;
    protected Address address;
    protected List<Role> roles;
    // private Role role;

    
    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
   
    @Override
    public String toString() {
        return "User{" + "email=" + email + ", age=" + age + ", workPosition=" + workPosition + '}';
    }
}

