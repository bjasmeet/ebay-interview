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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents Virtual Machine Runtime CPU
 * 
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "CPU")
@Entity
@Table(name = "VIRTUAL_MACHINE_RUNTIME_CPU", catalog = "metrics")
public class VirtualMachineRuntimeCPU {
    /**
     * 
     */
    private long id;
    /**
     * 
     */
    private List<VirtualMachineRuntimeCore> cores = new ArrayList<VirtualMachineRuntimeCore>();

    /**
     * 
     */
    public VirtualMachineRuntimeCPU() {
    }

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_RUNTIME_CPU_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VIRTUAL_MACHINE_RUNTIME_CPU_ID")
    public List<VirtualMachineRuntimeCore> getCores() {
        return cores;
    }

    /**
     * @param cores
     */
    public void setCores(List<VirtualMachineRuntimeCore> cores) {
        this.cores = cores;
    }

}
