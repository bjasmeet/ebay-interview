/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**Response entity for get virtual machine metric request
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "getvmmetricsresponse")
public class GetVirtualMachineMetricResponse {

    /**
     * 
     */
    private String message;
    /**
     * 
     */
    /**
     * 
     */
    private VirtualMachineMetrics vm;

    /**
     * 
     */
    /**
     * 
     */
    public GetVirtualMachineMetricResponse() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return
     */
    /**
     * @return
     */
    public VirtualMachineMetrics getVm() {
        return vm;
    }

    /**
     * @param vm
     */
    /**
     * @param vm
     */
    public void setVm(VirtualMachineMetrics vm) {
        this.vm = vm;
    }

}
