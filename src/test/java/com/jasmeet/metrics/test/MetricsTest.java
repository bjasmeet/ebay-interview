/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.WebClient;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jasmeet.metrics.entity.AddressWrapper;
import com.jasmeet.metrics.entity.GetMetricsResponse;
import com.jasmeet.metrics.entity.GetVirtualMachineMetricResponse;
import com.jasmeet.metrics.entity.StoreMetricsRequestState;
import com.jasmeet.metrics.entity.StoreMetricsRequestStatus;
import com.jasmeet.metrics.entity.StoreMetricsResponse;


/**Metrics Test Class
 * @author jasmbhat
 *
 */
public class MetricsTest {
    /**
     * 
     */
    private static final String BASE_URL="http://localhost:8080/ebay-interview/services/interview/metrics/";
    
    /**
     * @throws Exception
     */
    @BeforeClass
    public void beforeClass() throws Exception {
    }
    
    /**
     * @throws Exception
     */
    @AfterClass
    public void afterClass() throws Exception {
    }

    /**
     * @throws Exception
     */
    @BeforeMethod
    public void beforeMethod() throws Exception {
    }

    //@AfterMethod
    /**
     * 
     */
    public void afterMethord() {
    }


    
    /**
     * @throws Exception
     */
    @Test
    public void testGetStatus() throws Exception {
        String requestId = "request-"+12245;
        WebClient client = WebClient.create(BASE_URL);
        WebClient.getConfig(client).getHttpConduit().getClient()
                .setReceiveTimeout(0);
        client.path("status/"+requestId).accept("application/json");

        StoreMetricsRequestStatus storeMetricsRequestStatus = client.get(StoreMetricsRequestStatus.class);
        Assert.assertEquals(storeMetricsRequestStatus.getRequestId(), requestId);
        Assert.assertTrue(storeMetricsRequestStatus.getMessage() != null);
        Assert.assertEquals(storeMetricsRequestStatus.getState(), StoreMetricsRequestState.PROCESSED);

    }
    

    /**
     * @throws Exception
     */
    @Test
    public void testGetMetrics() throws Exception {
        String requestId = "request-"+12245;
        WebClient client = WebClient.create(BASE_URL);
        WebClient.getConfig(client).getHttpConduit().getClient()
                .setReceiveTimeout(0);
        client.path("getrequest/"+requestId).accept("application/json");

        GetMetricsResponse getMetricsResponse = client.get(GetMetricsResponse.class);
        Assert.assertEquals(getMetricsResponse.getRequestStatus().getRequestId(), requestId);
        Assert.assertEquals(getMetricsResponse.getRequestStatus().getState(), StoreMetricsRequestState.PROCESSED);
        Assert.assertTrue(getMetricsResponse.getVms().size()>0);

    }

    /**
     * @throws Exception
     */
    @Test
    public void testGetVMMetrics() throws Exception {
        String requestId = "request-"+12245;
        WebClient client = WebClient.create(BASE_URL);
        WebClient.getConfig(client).getHttpConduit().getClient()
                .setReceiveTimeout(0);
        client.path("getvm/"+requestId+"/metrics").accept("application/json");

        GetVirtualMachineMetricResponse getVirtualMachineMetricResponse = client.get(GetVirtualMachineMetricResponse.class);
        Assert.assertTrue(getVirtualMachineMetricResponse.getVm().getRuntime().getCpu().getCores().size() >0);

    }

    
    /**
     * @throws Exception
     */
    @Test
    public void testStoreMetrics() throws Exception {
        WebClient client = WebClient.create(BASE_URL);
        WebClient.getConfig(client).getHttpConduit().getClient()
                .setReceiveTimeout(0);
        client.path("store").type("application/json").accept("application/json");

        
        AddressWrapper addressWrapper = new AddressWrapper();
        List<String> addressList = new ArrayList<String>();
        addressList.add("1.2.3.4");
        addressList.add("4.3.2.1");
        addressWrapper.setAddresses(addressList);
        StoreMetricsResponse response = client.post(addressWrapper, StoreMetricsResponse.class);
        
        Assert.assertTrue(response.getRequestId() !=null);
        Assert.assertTrue(response.getMessage() !=null);

    }


}