package com.trues.webservice.service;

import com.trues.webservice.config.ServiceConfig;
import com.trues.webservice.config.model.Env;
import com.trues.webservice.config.model.Environments;
import com.trues.webservice.service.customerservice.*;
import com.trues.webservice.service.model.SearchTmvProfileModel;
import com.trues.webservice.service.model.WSObject;
import com.trues.webservice.util.TRUEUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


/**
 * User: son.nguyen
 * Date: 10/24/13
 * Time: 9:36 PM
 */
public class TRUEWService {

    private static Logger logger = LoggerFactory.getLogger(TRUEWService.class);
    private static String DEFAULT_CONFIG_PATH = "webservice_config.xml";

    private static Env activeEnv;

    private static boolean serviceStart = false;

    private static String path;

    /*static {
        try {
            initService();
        } catch (Exception e) {
            logger.error("", e);
            throw new RuntimeException("Can not start web service");
        }
    }
*/
    public static void initService() throws Exception {

        if (serviceStart == false) {

            path = TRUEUtils.getConfigFile(null, DEFAULT_CONFIG_PATH, 0);
            InputStream inputStream = null;
            if (path != null) {
                logger.info("===== Init service ===== " + path);
                inputStream = new FileInputStream(new File(path));
            } else {
                //load config from classpath
                logger.info("===== Init service from Class path ===== ");
                ClassPathResource cpr = new ClassPathResource(DEFAULT_CONFIG_PATH);
                inputStream = cpr.getInputStream();
                path = cpr.getPath();
            }
            //map xml config to object
            Environments environments = ServiceConfig.parse(inputStream);
            //get active environment
            activeEnv = environments.getActiveEnv();
            logger.info("===== Init profile: " + activeEnv.getName());
            //create service instance
            serviceStart = true;
            logger.info("===== DONE: Init service =====");
        }
    }

    public static WSObject<TmvCustomerServiceInfo> searchTmvProfile(String _sessionId, SearchTmvProfileModel inParams) throws Exception {
        initService();
        logger.info("===== call method : searchTmvProfile");
        WSObject<TmvCustomerServiceInfo> tmvCustomerServiceInfoWSObject = CustomerService.searchTmvProfile(_sessionId, activeEnv.getWebServiceConfig(), inParams);
        logger.info("===== return call method : searchTmvProfile");
        return tmvCustomerServiceInfoWSObject;
    }

    public static WSObject<TruCustomerServiceInfo> searchTruProfile(String _sessionId, SearchTmvProfileModel inParams) throws Exception {
        initService();
        return CustomerService.searchTruProfile(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<TvsCustomerServiceInfo> searchTvsProfile(String _sessionId, SearchTmvProfileModel inParams) throws Exception {
        initService();
        return CustomerService.searchTvsProfile(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<AllCustomerServiceInfo> searchAllCustomerProfile(String _sessionId, SearchTmvProfileModel inParams) throws Exception {
        initService();
        return CustomerService.searchAllCustomerProfile(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }


    /*public static void reloadConfig() {
        if (path != null && activeEnv != null) {
            logger.info("===== Reload webservice config =====" );
            try {
                FileInputStream inputStream = new FileInputStream(new File(path));
                Environments environments = ServiceConfig.parse(inputStream);
                Env env = environments.getActiveEnv();
                WebServiceConfig webServiceConfig = env.getWebServiceConfig();
                Map<String,Service> serviceMap = webServiceConfig.getServiceMap();
                WebServiceConfig localWsConfig = activeEnv.getWebServiceConfig();
                for (String name : serviceMap.keySet()) {
                    Service newService = serviceMap.get(name);
                    Service service = localWsConfig.looupService(name);
                    if (service != null && newService != null) {
                        //assign new timeout
                        service.setTimeout(newService.getTimeout());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            logger.info("===== DONE: Reload webservice config =====" );
        }
    }*/





   /* public static double CheckPayPerUse(String _sessionId, String ) {
        logger.info(_sessionId + " : " + ">>>>>>>>>>>>>>> call <<<<<<<<<<<<<<<<<<<<<<<");
        return D_LstPPSimST.D_LstPPSimST(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }*/


}
