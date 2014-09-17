package com.ais.webservice.service;

import com.trues.webservice.service.TRUEWService;
import com.trues.webservice.service.customerservice.CustomerServicesServiceStub;

/**
 * Created by Administrator on 17/09/2014.
 */
public class MainTest {

    public static void main(String[] args) {
        CustomerServicesServiceStub.SearchTmvProfile pr = new CustomerServicesServiceStub.SearchTmvProfile();
        TRUEWService.searchTmvProfile("aaa", pr);
    }
}
