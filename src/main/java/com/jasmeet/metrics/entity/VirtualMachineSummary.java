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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**Represents Virtual Machine Summary
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "summary")
@Entity
@Table(name = "VIRTUAL_MACHINE_SUMMARY", catalog = "metrics")
public class VirtualMachineSummary {

    private long id;
    /**
     * 
     */
    private long totalCPUUsage;

    /**
     * 
     */
    public VirtualMachineSummary() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "VIRTUAL_MACHINE_SUMMARY_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Column(name = "TOTAL_CPU_USAGE")
    public long getTotalCPUUsage() {
        return totalCPUUsage;
    }

    /**
     * @param totalCPUUsage
     */
    public void setTotalCPUUsage(long totalCPUUsage) {
        this.totalCPUUsage = totalCPUUsage;
    }

}
