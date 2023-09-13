/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String driver_id;
    private String driver_name;
    private String driver_surname;
    private String driver_email;
    private String driver_phone;
    private String driver_address;
    private String driver_password;
    @OneToMany
    @JoinTable(name="JOB")
    private List<Shipment> jobs;
    @Lob
    @Basic(fetch =FetchType.LAZY)
    private byte[] image;

    public Driver() {
    }

    
    public String getId() {
        return driver_id;
    }

    public void setId(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getDriver_surname() {
        return driver_surname;
    }

    public void setDriver_surname(String driver_surname) {
        this.driver_surname = driver_surname;
    }

    public String getDriver_email() {
        return driver_email;
    }

    public void setDriver_email(String driver_email) {
        this.driver_email = driver_email;
    }

    public String getDriver_phone() {
        return driver_phone;
    }

    public void setDriver_phone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public String getDriver_address() {
        return driver_address;
    }

    public void setDriver_address(String driver_address) {
        this.driver_address = driver_address;
    }

    public String getDriver_password() {
        return driver_password;
    }

    public void setDriver_password(String driver_password) {
        this.driver_password = driver_password;
    }

    public List<Shipment> getJobs() {
        return jobs;
    }

    public void setJobs(List<Shipment> jobs) {
        this.jobs = jobs;
    }


    public String getName() {
        return driver_name;
    }

    public void setName(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getSurname() {
        return driver_surname;
    }

    public void setSurname(String driver_surname) {
        this.driver_surname = driver_surname;
    }

    public String getEmail() {
        return driver_email;
    }

    public void setEmail(String driver_email) {
        this.driver_email = driver_email;
    }

    public String getPhone() {
        return driver_phone;
    }

    public void setPhone(String driver_phone) {
        this.driver_phone = driver_phone;
    }

    public String getAddress() {
        return driver_address;
    }

    public void setAddress(String driver_address) {
        this.driver_address = driver_address;
    }

    public String getPassword() {
        return driver_password;
    }

    public void setPassword(String driver_password) {
        this.driver_password = driver_password;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Driver{" + "driver_id=" + driver_id + ", driver_name=" + driver_name + ", driver_surname=" + driver_surname + ", driver_email=" + driver_email + ", driver_phone=" + driver_phone + ", driver_address=" + driver_address + ", driver_password=" + driver_password + ", image=" + image + '}';
    }
  
    
}
