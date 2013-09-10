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
 * Represents Virtual Machine Runtime Core
 * 
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "core")
@Entity
@Table(name = "VIRTUAL_MACHINE_RUNTIME_CORE", catalog = "metrics")
public class VirtualMachineRuntimeCore {
    private long id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private int usageInPercentage;

    /**
     * 
     */
    public VirtualMachineRuntimeCore() {
    }

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_RUNTIME_CORE_ID")
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
     * @return
     */
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    @Column(name = "USAGE_IN_PERCENTAGE")
    public int getUsageInPercentage() {
        return usageInPercentage;
    }

    /**
     * @param usageInPercentage
     */
    public void setUsageInPercentage(int usageInPercentage) {
        this.usageInPercentage = usageInPercentage;
    }

}
