/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.jasmeet.metrics.entity.AddressWrapper;
import com.jasmeet.metrics.entity.GetMetricsResponse;
import com.jasmeet.metrics.entity.GetVirtualMachineMetricResponse;
import com.jasmeet.metrics.entity.StoreMetricsRequestStatus;
import com.jasmeet.metrics.entity.StoreMetricsResponse;

/**Service interface for Metrics. This class contains all the necessary APIs to generate/query/fetch
 * metrics information for VMs.
 * @author jasmbhat
 *
 */
public interface MetricsService {

    /**store metrics for a given set of vm addresses
     * @param addresses
     * @return acknowledgement with requestid
     */
    @POST
    @Path("/store")
    @Produces("application/json")
    @Consumes("application/json")
    public StoreMetricsResponse storeMetrics(AddressWrapper addressWrapper);
    
    
    /**gets the status of the processing of the given request id.
     * @param requestId
     * @return
     */
    @GET
    @Path("/status/{requestId}")
    @Produces("application/json")
    public StoreMetricsRequestStatus getStatus(@PathParam("requestId") String requestId);
    
    /**Gets metrics information associated with the request
     * @param requestId
     * @return
     */
    @GET
    @Path("/getrequest/{requestId}")
    @Produces("application/json")
    public GetMetricsResponse getMetrics(@PathParam("requestId") String requestId);
    

    /**Gets metrics information for a given VM.
     * @param address
     * @return
     */
    @GET
    @Path("/getvm/{address}/metrics")
    @Produces("application/json")
    public GetVirtualMachineMetricResponse getVMMetrics(@PathParam("address") String address);


    
}
