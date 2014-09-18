package com.trues.webservice.service.customerservice;

import com.trues.webservice.config.model.Param;
import com.trues.webservice.config.model.Service;
import com.trues.webservice.config.model.WebServiceConfig;
import com.trues.webservice.service.model.WSObject;
import com.trues.webservice.util.TRUELogUtil;
import com.trues.webservice.util.TRUEUtils;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import th.co.tit.ccbint.balance.datatype.TmvCustomerServiceInfo;
import th.co.tit.ccbint.balance.datatype.TruCustomerServiceInfo;
import th.co.tit.ccbint.balance.datatype.TvsCustomerServiceInfo;
import th.co.tit.ccbint.mcp.webservices.*;

import java.util.Map;

/**
 * Created by Administrator on 17/09/2014.
 */
public class CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public static WSObject<TmvCustomerServiceInfo> searchTmvProfile(String _sessionId, WebServiceConfig configs, SearchTmvProfile inParams) {
        String methodName = "searchTmvProfile";
        Service cf = configs.looupService(methodName);
        WSObject<TmvCustomerServiceInfo> result = new WSObject<TmvCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceStub stub = new CustomerServicesServiceStub(cf.getEndpoint());
                stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(cf.getTimeout());

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        auth.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        auth.setPassword(cf.getPassword());
                    }
                    stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTmvProfile();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);

                SearchTmvProfileResponse tmvProfileResponse = stub.searchTmvProfile(inParams);
                result.setResult(tmvProfileResponse.getSearchTmvProfileReturn());

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

    public static WSObject<TruCustomerServiceInfo> searchTruProfile(String _sessionId, WebServiceConfig configs, SearchTruProfile inParams) {
        String methodName = "searchTruProfile";
        Service cf = configs.looupService(methodName);
        WSObject<TruCustomerServiceInfo> result = new WSObject<TruCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceStub stub = new CustomerServicesServiceStub(cf.getEndpoint());
                stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(cf.getTimeout());

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        auth.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        auth.setPassword(cf.getPassword());
                    }
                    stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTruProfile();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);

                SearchTruProfileResponse truProfileResponse = stub.searchTruProfile(inParams);
                result.setResult(truProfileResponse.getSearchTruProfileReturn());

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

    public static WSObject<TvsCustomerServiceInfo> searchTvsProfile(String _sessionId, WebServiceConfig configs, SearchTvsProfile inParams) {
        String methodName = "searchTvsProfile";
        Service cf = configs.looupService(methodName);
        WSObject<TvsCustomerServiceInfo> result = new WSObject<TvsCustomerServiceInfo>();
        if (cf != null) {
            try {
                CustomerServicesServiceStub stub = new CustomerServicesServiceStub(cf.getEndpoint());
                stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(cf.getTimeout());

                if (StringUtils.isNotEmpty(cf.getUsername()) || StringUtils.isNotEmpty(cf.getPassword())) {
                    HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
                    if (StringUtils.isNotEmpty(cf.getUsername())) {
                        auth.setUsername(cf.getUsername());
                    }
                    if (StringUtils.isNotEmpty(cf.getPassword())) {
                        auth.setPassword(cf.getPassword());
                    }
                    stub._getServiceClient().getOptions().setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
                }
                //override by default param
                Map<String, Param> params = cf.getParams();
                if (inParams == null) {
                    inParams = new SearchTvsProfile();
                }

                TRUEUtils.overrideFromParams(inParams, params);
                TRUELogUtil.printInput(logger, _sessionId, methodName, cf, null, inParams);

                SearchTvsProfileResponse tvsProfileResponse = stub.searchTvsProfile(inParams);
                result.setResult(tvsProfileResponse.getSearchTvsProfileReturn());

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
