package com.trues.webservice.service.customerservice;

import com.trues.webservice.config.model.Param;
import com.trues.webservice.config.model.Service;
import com.trues.webservice.config.model.WebServiceConfig;
import com.trues.webservice.service.model.SearchTmvProfileModel;
import com.trues.webservice.service.model.WSObject;
import com.trues.webservice.util.TRUELogUtil;
import com.trues.webservice.util.TRUEUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Map;

/**
 * Created by Administrator on 17/09/2014.
 */
public class CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public static WSObject<TmvCustomerServiceInfo> searchTmvProfile(String _sessionId, WebServiceConfig configs,
                                                                    SearchTmvProfileModel inParams) {
        logger.info("11nn===== begin call method : searchTmvProfile ");
        String methodName = "searchTmvProfile";
        Service cf = configs.looupService(methodName);
        logger.info("nn===== begin call method : searchTmvProfile {} {}", _sessionId ,cf.getEndpoint());
        WSObject<TmvCustomerServiceInfo> result = new WSObject<TmvCustomerServiceInfo>();
        if (cf != null) {
            try {
                logger.info("go to try 1{} {}", _sessionId ,cf.getEndpoint());
                CustomerServicesServiceLocator locator = new CustomerServicesServiceLocator();
                CustomerServicesSoapBindingStub stub = (CustomerServicesSoapBindingStub)locator.getCustomerServices(new URL(cf.getEndpoint()));
                logger.info("go to try 2{} {}", _sessionId ,cf.getEndpoint());

                logger.info("===== call ws 1 : searchTmvProfile {} {}", _sessionId, cf.getEndpoint());
                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        stub.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        stub.setPassword(cf.getPassword());
                    }
                }
                logger.info("===== call ws 2 : searchTmvProfile {}", _sessionId);
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTmvProfileModel();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                logger.info("===== call ws 3 : searchTmvProfile {}", _sessionId);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);
                logger.info("===== call ws 4 : searchTmvProfile {}", _sessionId);
                TmvCustomerServiceInfo tmvProfileResponse = stub.searchTmvProfile(inParams.getUserId(), inParams.getPassword(),
                        inParams.getSearchType(), inParams.getKeyValue());
                logger.info("===== call ws 5 : searchTmvProfile {}", _sessionId);
                result.setResult(tmvProfileResponse);
                logger.info("===== call ws 6 : searchTmvProfile {}", _sessionId);

            } catch (Exception e) {
                logger.info("===== errorrrrrrrrrrr ================", _sessionId);
                result.setErrorCode(1);
                result.setErrorMsg(e.getMessage());
                logger.error(_sessionId + " : ", e);
            }
        } else {
            logger.error(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorMsg(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorCode(2);
        }
        TRUELogUtil.printOutput(logger, _sessionId, methodName, result, null);
        logger.info("===== done call method : searchTmvProfile");
        return result;
    }

    public static WSObject<TruCustomerServiceInfo> searchTruProfile(String _sessionId, WebServiceConfig configs, SearchTmvProfileModel inParams) {
        String methodName = "searchTruProfile";
        Service cf = configs.looupService(methodName);
        WSObject<TruCustomerServiceInfo> result = new WSObject<TruCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceLocator locator = new CustomerServicesServiceLocator();
                CustomerServicesSoapBindingStub stub = (CustomerServicesSoapBindingStub)locator.getCustomerServices(new URL(cf.getEndpoint()));

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        stub.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        stub.setPassword(cf.getPassword());
                    }
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTmvProfileModel();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);
                TruCustomerServiceInfo tmvProfileResponse = stub.searchTruProfile(inParams.getUserId(), inParams.getPassword(),
                        inParams.getSearchType(), inParams.getKeyValue());
                result.setResult(tmvProfileResponse);

            } catch (Exception e) {
                result.setErrorCode(1);
                result.setErrorMsg(e.getMessage());
                logger.error(_sessionId + " : ", e);
            }
        } else {
            logger.error(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorMsg(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorCode(2);
        }
        TRUELogUtil.printOutput(logger, _sessionId, methodName, result, null);
        return result;
    }

    public static WSObject<TvsCustomerServiceInfo> searchTvsProfile(String _sessionId, WebServiceConfig configs, SearchTmvProfileModel inParams) {
        String methodName = "searchTvsProfile";
        Service cf = configs.looupService(methodName);
        WSObject<TvsCustomerServiceInfo> result = new WSObject<TvsCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceLocator locator = new CustomerServicesServiceLocator();
                CustomerServicesSoapBindingStub stub = (CustomerServicesSoapBindingStub)locator.getCustomerServices(new URL(cf.getEndpoint()));

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        stub.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        stub.setPassword(cf.getPassword());
                    }
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTmvProfileModel();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);
                TvsCustomerServiceInfo tmvProfileResponse = stub.searchTvsProfile(inParams.getUserId(), inParams.getPassword(),
                        inParams.getSearchType(), inParams.getKeyValue());
                result.setResult(tmvProfileResponse);

            } catch (Exception e) {
                result.setErrorCode(1);
                result.setErrorMsg(e.getMessage());
                logger.error(_sessionId + " : ", e);
            }
        } else {
            logger.error(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorMsg(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorCode(2);
        }
        TRUELogUtil.printOutput(logger, _sessionId, methodName, result, null);
        return result;
    }

    public static WSObject<AllCustomerServiceInfo> searchAllCustomerProfile(String _sessionId, WebServiceConfig configs, SearchTmvProfileModel inParams) {
        String methodName = "searchAllCustomerProfile";
        Service cf = configs.looupService(methodName);
        WSObject<AllCustomerServiceInfo> result = new WSObject<AllCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceLocator locator = new CustomerServicesServiceLocator();
                CustomerServicesSoapBindingStub stub = (CustomerServicesSoapBindingStub)locator.getCustomerServices(new URL(cf.getEndpoint()));

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        stub.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        stub.setPassword(cf.getPassword());
                    }
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTmvProfileModel();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);
                AllCustomerServiceInfo tmvProfileResponse = stub.searchAllCustomerProfile(inParams.getUserId(), inParams.getPassword(),
                        inParams.getSearchType(), inParams.getKeyValue());
                result.setResult(tmvProfileResponse);

            } catch (Exception e) {
                result.setErrorCode(1);
                result.setErrorMsg(e.getMessage());
                logger.error(_sessionId + " : ", e);
            }
        } else {
            logger.error(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorMsg(_sessionId + " : " + "Can not found the config for " + methodName);
            result.setErrorCode(2);
        }
        TRUELogUtil.printOutput(logger, _sessionId, methodName, result, null);
        return result;
    }
}
