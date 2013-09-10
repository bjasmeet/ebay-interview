/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.dao;

import java.util.Date;
import java.util.List;

import com.jasmeet.metrics.entity.GetMetricsResponse;
import com.jasmeet.metrics.entity.StoreMetricsRequestStatus;
import com.jasmeet.metrics.entity.VirtualMachineMetrics;
import com.jasmeet.metrics.exception.MetricsCheckedException;
import com.jasmeet.metrics.exception.RequestNotFoundExeption;
import com.jasmeet.metrics.exception.VMNotFoundException;

/**Data Access Interface for metrics
 * @author jasmbhat
 *
 */
public interface MetricsDAO {

    /**Stores metrics for a given request and associated VMs
     * @param requestId
     * @param vms
     * @param timestamp
     * @throws MetricsCheckedException
     */
    public void storeMetrics(String requestId, List<VirtualMachineMetrics> vms, Date timestamp) throws MetricsCheckedException;
    
    /**Gets the status of the request
     * @param requestId
     * @return
     * @throws RequestNotFoundExeption
     */
    public StoreMetricsRequestStatus getStatus(String requestId) throws RequestNotFoundExeption;

    
    /**Gets metrics information associated with the request
     * @param requestId
     * @return
     * @throws RequestNotFoundExeption
     */
    public GetMetricsResponse getMetrics(String requestId) throws RequestNotFoundExeption;
    

    /**Gets VM metrics for the address.
     * @param address
     * @return
     * @throws VMNotFoundException
     */
    public VirtualMachineMetrics getVMMetrics(String address) throws VMNotFoundException;

}
