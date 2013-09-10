/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents Virtual Machine Runtime Memory
 * 
 * @author jasmbhat
 * 
 */
/**
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "mem")
@Entity
@Table(name = "VIRTUAL_MACHINE_RUNTIME_MEMORY", catalog = "metrics")
public class VirtualMachineRuntimeMemory {
    private long id;
    /**
     * 
     */
    private long used;
    /**
     * 
     */
    private long free;
    /**
     * 
     */
    private String unit = "MB";

    /**
     * 
     */
    public VirtualMachineRuntimeMemory() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_RUNTIME_MEMORY_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Column(name = "USED")
    public long getUsed() {
        return used;
    }

    /**
     * @param used
     */
    public void setUsed(long used) {
        this.used = used;
    }

    /**
     * @return
     */
    @Column(name = "FREE")
    public long getFree() {
        return free;
    }

    /**
     * @param free
     */
    public void setFree(long free) {
        this.free = free;
    }

    /**
     * @return
     */
    @Column(name = "UNIT")
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
