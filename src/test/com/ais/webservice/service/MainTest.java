package com.ais.webservice.service;

import com.trues.webservice.service.TRUEWService;
import com.trues.webservice.service.model.SearchTmvProfileModel;

/**
 * Created by Administrator on 17/09/2014.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
       /* SearchTmvProfile pr = new SearchTmvProfile();
        TRUEWService.searchTmvProfile("aaa", pr);*/
        /*SearchTruProfile ob = new SearchTruProfile();
        ob.setKeyValue("aa");
        ob.setUserId("ff");
        ob.setPassword("dd");
        TRUEWService.searchTruProfile("dd", ob);*/
        //TRUEWService.searchTvsProfile("dd", null);
        SearchTmvProfileModel ob = new SearchTmvProfileModel();
        ob.setUserId("AICM");
        ob.setPassword("AICMOPER");
        ob.setSearchType("CERTIFICATE");
        ob.setKeyValue("3101390000269");
        TRUEWService.searchAllCustomerProfile("dd", ob);
    }
}
