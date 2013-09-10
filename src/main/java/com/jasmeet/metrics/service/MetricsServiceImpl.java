/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

import org.springframework.beans.factory.annotation.Autowired;

import com.jasmeet.metrics.dao.MetricsDAO;
import com.jasmeet.metrics.entity.AddressWrapper;
import com.jasmeet.metrics.entity.GetMetricsResponse;
import com.jasmeet.metrics.entity.GetVirtualMachineMetricResponse;
import com.jasmeet.metrics.entity.StoreMetricsRequestStatus;
import com.jasmeet.metrics.entity.StoreMetricsResponse;
import com.jasmeet.metrics.entity.VirtualMachineMetrics;
import com.jasmeet.metrics.exception.MetricsCheckedException;
import com.jasmeet.metrics.exception.RequestNotFoundExeption;
import com.jasmeet.metrics.exception.VMNotFoundException;
import com.jasmeet.metrics.util.MetricUtils;

/**
 * Implementation class for metrics service. Internally talks to the Metrics DAO
 * for managing VM entity persistence
 * 
 * @author jasmbhat
 * 
 */
@Path("/metrics")
public class MetricsServiceImpl implements MetricsService {
    /**
     * 
     */
    @Autowired
    private MetricsDAO metricsDAO;

    /**
     * 
     */
    public MetricsServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jasmeet.metrics.service.MetricsService#storeMetrics(java.util.List)
     */
    public StoreMetricsResponse storeMetrics(AddressWrapper addressWrapper) {
        // TODO Auto-generated method stub

        String requestId = "request-"+MetricUtils.randInt(1, 1000000);
        List<VirtualMachineMetrics> vms = new ArrayList<VirtualMachineMetrics>();

        if(addressWrapper != null && addressWrapper.getAddresses().size()>0){
            for(String address: addressWrapper.getAddresses()){
                VirtualMachineMetrics vm1 = MetricUtils
                        .generateMockVirtualMachineData(address);
                vms.add(vm1);
            }
        }
        

        try {
            metricsDAO.storeMetrics(requestId, vms,
                    new Date(System.currentTimeMillis()));
        } catch (MetricsCheckedException e) {
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }

        StoreMetricsResponse response = new StoreMetricsResponse();
        response.setRequestId(requestId);
        response.setMessage("Request In-progress");

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jasmeet.metrics.service.MetricsService#getStatus(java.lang.String)
     */
    public StoreMetricsRequestStatus getStatus(String requestId) {
        try {
            return metricsDAO.getStatus(requestId);
        } catch (RequestNotFoundExeption e) {
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jasmeet.metrics.service.MetricsService#getMetrics(java.lang.String)
     */
    public GetMetricsResponse getMetrics(String requestId) {
        try {
            return metricsDAO.getMetrics(requestId);
        } catch (RequestNotFoundExeption e) {
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.jasmeet.metrics.service.MetricsService#getVMMetrics(java.lang.String)
     */
    public GetVirtualMachineMetricResponse getVMMetrics(String address) {
        GetVirtualMachineMetricResponse response = new GetVirtualMachineMetricResponse();
        response.setMessage("mock message");
        try {
            response.setVm(metricsDAO.getVMMetrics(address));
        } catch (VMNotFoundException e) {
            // TODO Auto-generated catch block
            throw new WebApplicationException(e);
        }

        return response;
    }


}
