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
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
 private String client_id;
    private String client_name;
    private String client_surname;
    private String client_email;
    private String client_phone;
    private String client_address;
    private String client_password;

    public Client() {
    }



    public String getId() {
        return client_id;
    }

    public void setId(String client_id) {
        this.client_id= client_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (client_id != null ? client_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.client_id == null && other.client_id != null) || (this.client_id != null && !this.client_id.equals(other.client_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", client_name=" + client_name + ", client_surname=" + client_surname + ", client_email=" + client_email + ", client_phone=" + client_phone + ", client_address=" + client_address + ", client_password=" + client_password + '}';
    }


    public String getEmail() {
        return client_email;
    }

    public void setEmail(String client_email) {
        this.client_email = client_email;
    }

    public String getPhone() {
        return client_phone;
    }

    public void setPhone(String client_phone) {
        this.client_phone = client_phone;
    }

    public String getAddress() {
        return client_address;
    }

    public void setAddress(String client_address) {
        this.client_address = client_address;
    }

    public String getPassword() {
        return client_password;
    }

    public void setPassword(String client_password) {
        this.client_password = client_password;
    }

    public String getName() {
        return client_name;
    }

    public void setName(String client_name) {
        this.client_name = client_name;
    }

    public String getSurname() {
        return client_surname;
    }

    public void setSurname(String client_surname) {
        this.client_surname = client_surname;
    }
    
    
}
