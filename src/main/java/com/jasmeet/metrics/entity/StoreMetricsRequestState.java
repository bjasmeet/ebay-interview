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

/**Represents the State enumerations
 * @author jasmbhat
 *
 */
@XmlRootElement(name = "requeststate")
public enum StoreMetricsRequestState {
    UKNOWN, PROCESSED, INPROGRESS;
}
