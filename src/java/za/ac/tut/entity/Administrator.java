/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author User
 */
@Entity
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer employee_id;
    private String username;
    private String password;
    private String access_level;

    public Administrator() {
    }

    
    
    public Administrator(Integer employee_id, String username, String password, String access_level) {
        this.employee_id = employee_id;
        this.username = username;
        this.password = password;
        this.access_level = access_level;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccess_level() {
        return access_level;
    }

    public void setAccess_level(String access_level) {
        this.access_level = access_level;
    }

   
}
