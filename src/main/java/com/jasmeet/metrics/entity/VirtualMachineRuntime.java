/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents Virtual Machine Runtime
 * 
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "runtime")
@Entity
@Table(name = "VIRTUAL_MACHINE_RUNTIME", catalog = "metrics")
public class VirtualMachineRuntime {

    private long id;
    /**
     * 
     */
    private VirtualMachineRuntimeCPU cpu;
    /**
     * 
     */
    private VirtualMachineRuntimeMemory memory;

    /**
     * 
     */
    public VirtualMachineRuntime() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_RUNTIME_ID")
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VIRTUAL_MACHINE_RUNTIME_MEMORY_ID")
    public VirtualMachineRuntimeMemory getMemory() {
        return memory;
    }

    /**
     * @param memory
     */
    public void setMemory(VirtualMachineRuntimeMemory memory) {
        this.memory = memory;
    }

    /**
     * @return
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "VIRTUAL_MACHINE_RUNTIME_CPU_ID")
    public VirtualMachineRuntimeCPU getCpu() {
        return cpu;
    }

    /**
     * @param cpu
     */
    public void setCpu(VirtualMachineRuntimeCPU cpu) {
        this.cpu = cpu;
    }

}
