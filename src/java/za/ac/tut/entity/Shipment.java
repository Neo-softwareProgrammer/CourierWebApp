/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Shipment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String shipment_id;


    private Client client;
    private String description;
    private String service_req;
    private String status;
    private String type;
    private String jobAllocation;
    private String deliveryAddress;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date collection_date;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date delivery_date;

    public Shipment() {
    }

    public String getId() {
        return shipment_id;
    }

    public void setId(String shipment_id) {
        this.shipment_id = shipment_id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipment_id != null ? shipment_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shipment)) {
            return false;
        }
        Shipment other = (Shipment) object;
        return !((this.shipment_id == null && other.shipment_id != null) || (this.shipment_id != null && !this.shipment_id.equals(other.shipment_id)));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getService_req() {
        return service_req;
    }

    public void setService_req(String service_req) {
        this.service_req = service_req;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipment_id() {
        return shipment_id;
    }

    public void setShipment_id(String shipment_id) {
        this.shipment_id = shipment_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCollection_date() {
        return collection_date;
    }

    public void setCollection_date(Date collection_date) {
        this.collection_date = collection_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    @Override
    public String toString() {
        return "Shipment{" + "shipment_id=" + shipment_id + ", client=" + client + ", description=" + description + ", service_req=" + service_req + ", status=" + status + ", collection_date=" + collection_date + ", delivery_date=" + delivery_date + '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJobAllocation() {
        return jobAllocation;
    }

    public void setJobAllocation(String jobAllocation) {
        this.jobAllocation = jobAllocation;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    
 
}
