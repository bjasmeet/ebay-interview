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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**Represents Virtual Machine metrics 
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "virtualmachinemetrics")
@Entity
@Table(name = "VIRTUAL_MACHINE_METRICS", catalog = "metrics", uniqueConstraints = {
                @UniqueConstraint(columnNames = "ADDRESS") })
public class VirtualMachineMetrics {
    /**
     * 
     */
    private long id;
    /**
     * 
     */
    private String address;
    /**
     * 
     */
    private VirtualMachineRuntime runtime;
    /**
     * 
     */
    private VirtualMachineSummary summary;

    /**
     * 
     */
    public VirtualMachineMetrics() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "VIRTUAL_MACHINE_RUNTIME_ID")
    public VirtualMachineRuntime getRuntime() {
        return runtime;
    }

    /**
     * @param runtime
     */
    public void setRuntime(VirtualMachineRuntime runtime) {
        this.runtime = runtime;
    }

    
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_METRIC_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "VIRTUAL_MACHINE_SUMMARY_ID")
    public VirtualMachineSummary getSummary() {
        return summary;
    }

    /**
     * @param summary
     */
    public void setSummary(VirtualMachineSummary summary) {
        this.summary = summary;
    }

    /**
     * @return
     */
    @Column(name = "ADDRESS", nullable = false)
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

}
