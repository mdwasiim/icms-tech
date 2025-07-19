/*
package com.qr.icms.common.support;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceDiscoveryClient {

    LoadBalancerClient  loadBalancerClient;

    @Autowired
    public ServiceDiscoveryClient (LoadBalancerClient loadBalancerClient){
        this.loadBalancerClient = loadBalancerClient;
    }

    public String getServiceURL(String serviceName){

        ServiceInstance choose = loadBalancerClient.choose(serviceName);

    }

}
*/
