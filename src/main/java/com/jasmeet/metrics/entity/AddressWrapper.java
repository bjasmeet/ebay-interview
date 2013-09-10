/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Address wrapper for taking request addresses as a list of strings
 * 
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "addresswrapper")
@Entity
@Table(name = "REQUEST_ADDRESSES", catalog = "metrics")
public class AddressWrapper {
    /**
     * 
     */
    private long id;
    /**
     * 
     */
    private List<String> addresses = new ArrayList<String>();

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "REQUEST_ADDRESSES_ID")
    public long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 
     */
    public AddressWrapper() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    @ElementCollection
    @CollectionTable(name = "ADDRESSES", joinColumns = @JoinColumn(name = "REQUEST_ADDRESSES_ID"))
    @Column(name = "ADDRESS")
    public List<String> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses
     */
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

}
