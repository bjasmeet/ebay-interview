/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jasmeet.metrics.entity.GetMetricsResponse;
import com.jasmeet.metrics.entity.StoreMetricsRequestState;
import com.jasmeet.metrics.entity.StoreMetricsRequestStatus;
import com.jasmeet.metrics.entity.VirtualMachineMetrics;
import com.jasmeet.metrics.exception.MetricsCheckedException;
import com.jasmeet.metrics.exception.RequestNotFoundExeption;
import com.jasmeet.metrics.exception.VMNotFoundException;
import com.jasmeet.metrics.util.MetricUtils;

@Repository("metricsDao")
public class MetricsDAOImpl implements MetricsDAO {

    public MetricsDAOImpl() {
        // TODO Auto-generated constructor stub
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void storeMetrics(String requestId, List<VirtualMachineMetrics> vms,
            Date timestamp) throws MetricsCheckedException {
        // TODO Auto-generated method stub

    }

    public StoreMetricsRequestStatus getStatus(String requestId)
            throws RequestNotFoundExeption {

        StoreMetricsRequestStatus requestStatus = new StoreMetricsRequestStatus();
        requestStatus.setMessage("request processed");
        requestStatus.setRequestId(requestId);
        requestStatus.setState(StoreMetricsRequestState.PROCESSED);

        return requestStatus;
    }

    public GetMetricsResponse getMetrics(String requestId)
            throws RequestNotFoundExeption {

        GetMetricsResponse getMetricsResponse = new GetMetricsResponse();
        StoreMetricsRequestStatus requestStatus = new StoreMetricsRequestStatus();
        requestStatus.setMessage("request processed");
        requestStatus.setRequestId(requestId);
        requestStatus.setState(StoreMetricsRequestState.PROCESSED);

        List<VirtualMachineMetrics> vms = new ArrayList<VirtualMachineMetrics>();

        VirtualMachineMetrics vm1 = MetricUtils
                .generateMockVirtualMachineData("1.2.3.4");
        VirtualMachineMetrics vm2 = MetricUtils
                .generateMockVirtualMachineData("4.3.2.1");

        vms.add(vm1);
        vms.add(vm2);
        getMetricsResponse.setVms(vms);
        getMetricsResponse.setRequestStatus(requestStatus);
        return getMetricsResponse;

    }

    public VirtualMachineMetrics getVMMetrics(String address)
            throws VMNotFoundException {
        return MetricUtils.generateMockVirtualMachineData(address);
    }

}
