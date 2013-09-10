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

/**Response entity for store metrics request
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "storemetricsresponse")
public class StoreMetricsResponse {
    /**
     * 
     */
    private String requestId;
    /**
     * 
     */
    private String message;

    /**
     * 
     */
    public StoreMetricsResponse() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
