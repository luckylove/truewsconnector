package com.trues.webservice.service;

import com.trues.webservice.config.ServiceConfig;
import com.trues.webservice.config.model.Env;
import com.trues.webservice.config.model.Environments;
import com.trues.webservice.config.model.Service;
import com.trues.webservice.config.model.WebServiceConfig;
import com.trues.webservice.util.TRUEUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;


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

    static {
        try {
            initService();
        } catch (Exception e) {
            logger.error("", e);
            throw new RuntimeException("Can not start web service");
        }
    }

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
            /*if (StringUtils.isNotEmpty(activeEnv.getKeyStore())) {
                logger.info("=====  Init SSL Context ===== " + activeEnv.getKeyStore());
                System.setProperty("javax.net.ssl.trustStore", activeEnv.getKeyStore());
                System.setProperty("javax.net.ssl.keyStore", activeEnv.getKeyStore());
                System.setProperty("-Djavax.net.ssl.keyStorePassword", "123456");
                System.setProperty("javax.net.debug","all");
                System.setProperty("java.security.debug","all");
            }*/

            System.setProperty("axis.socketSecureFactory",
                    "org.apache.axis.components.net.SunFakeTrustSocketFactory");
        }
    }

    public static void reloadConfig() {
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
    }





   /* public static double CheckPayPerUse(String _sessionId, String ) {
        logger.info(_sessionId + " : " + ">>>>>>>>>>>>>>> call <<<<<<<<<<<<<<<<<<<<<<<");
        return D_LstPPSimST.D_LstPPSimST(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }*/


}
