/******************************************************************************
 * Copyright (c) 2013 by Jasmeet bhatia. All rights reserved.
 * 
 * This software contains proprietary information which shall not be reproduced
 * or transferred to other documents and shall not be disclosed to others or
 * used for manufacturing or any other purpose without prior permission of Jasmeet Bhatia.
 * 
 *****************************************************************************/
package com.jasmeet.metrics.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.jasmeet.metrics.entity.VirtualMachineMetrics;
import com.jasmeet.metrics.entity.VirtualMachineRuntime;
import com.jasmeet.metrics.entity.VirtualMachineRuntimeCPU;
import com.jasmeet.metrics.entity.VirtualMachineRuntimeCore;
import com.jasmeet.metrics.entity.VirtualMachineRuntimeMemory;
import com.jasmeet.metrics.entity.VirtualMachineSummary;

/**Utility Methods
 * @author jasmbhat
 *
 */
public class MetricUtils {

    
    /**generate and return a random integer
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    /**Generates mock data
     * @param address
     * @return
     */
    public static VirtualMachineMetrics generateMockVirtualMachineData(String address){
        VirtualMachineMetrics virtualMachine = new VirtualMachineMetrics();
        VirtualMachineRuntime runtime = new VirtualMachineRuntime();
        VirtualMachineSummary summary =  new VirtualMachineSummary();
        VirtualMachineRuntimeMemory memory = new VirtualMachineRuntimeMemory();
        
        VirtualMachineRuntimeCPU cpu = new VirtualMachineRuntimeCPU();
        List<VirtualMachineRuntimeCore> cores = new ArrayList<VirtualMachineRuntimeCore>();
        
        for(int i=0;i<MetricUtils.randInt(1, 5);i++){
            VirtualMachineRuntimeCore core = new VirtualMachineRuntimeCore();
            core.setName("core"+i+1);
            core.setUsageInPercentage(MetricUtils.randInt(1, 100));
            cores.add(core);
        }
        
        
        cpu.setCores(cores);
        runtime.setCpu(cpu);

        memory.setFree(MetricUtils.randInt(1, 160000));
        memory.setUsed(MetricUtils.randInt(1, 160000));
        memory.setUnit("MB");
        summary.setTotalCPUUsage(MetricUtils.randInt(1, 100));
        
        virtualMachine.setRuntime(runtime);
        virtualMachine.setAddress(address);
        virtualMachine.setSummary(summary);

        
        return virtualMachine;
    }



}
