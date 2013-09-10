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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents the status ack for the store metrics post.
 * 
 * @author jasmbhat
 * 
 */
@XmlRootElement(name = "requeststatus")
@Entity
@Table(name = "STORE_METRICS_REQUEST_STATUS", catalog = "metrics", uniqueConstraints = {
        @UniqueConstraint(columnNames = "REQUEST_ID") })
public class StoreMetricsRequestStatus {
    /**
     * 
     */
    private long id;
    /**
     * 
     */
    private String requestId;
    /**
     * 
     */
    private StoreMetricsRequestState state;
    /**
     * 
     */
    private String message;

    /**
     * 
     */
    public StoreMetricsRequestStatus() {
        // TODO Auto-generated constructor stub
    }

    @XmlTransient
    @Id
    @GeneratedValue
    @Column(name = "STORE_METRICS_REQUEST_STATUS_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return
     */
    @Column(name = "REQUEST_ID", nullable = false)
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

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    public StoreMetricsRequestState getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(StoreMetricsRequestState state) {
        this.state = state;
    }

    /**
     * @return
     */
    @Column(name = "MESSAGE")
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
