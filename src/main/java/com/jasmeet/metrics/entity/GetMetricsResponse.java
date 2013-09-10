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

import javax.xml.bind.annotation.XmlRootElement;


/**Represents the Response entity for the get metrics query
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "getmetricsresponse")
public class GetMetricsResponse {
    /**
     * 
     */
    private StoreMetricsRequestStatus requestStatus;
    /**
     * 
     */
    private List<VirtualMachineMetrics> vms = new ArrayList<VirtualMachineMetrics>();

    /**
     * 
     */
    public GetMetricsResponse() {
    }

    /**
     * @return
     */
    public StoreMetricsRequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * @param requestStatus
     */
    public void setRequestStatus(StoreMetricsRequestStatus requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * @return
     */
    public List<VirtualMachineMetrics> getVms() {
        return vms;
    }

    /**
     * @param vms
     */
    public void setVms(List<VirtualMachineMetrics> vms) {
        this.vms = vms;
    }
    
    

}
