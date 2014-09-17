package com.trues.webservice.service;

import com.ais.webservice.service.a_getcusinfo.A_GetCCCusInfo;
import com.ais.webservice.service.a_getcusinfo.Fml32_A_GetCCCustInfo_Out;
import com.ais.webservice.service.a_getcusinfo2.A_GetCCCusInfo2;
import com.ais.webservice.service.a_getcusinfo2.Webservice_acc_BindingQSServiceStub;
import com.ais.webservice.service.adc.refillcard.RefillCard;
import com.ais.webservice.service.adc.resetpassword.ResetPassword;
import com.ais.webservice.service.adc.resetport.ResetPort;
import com.ais.webservice.service.csr.a_dcupd_autoem.A_DCUpdAutoEm;
import com.ais.webservice.service.csr.a_dcupd_autoem.Fml32_A_DCUpdAutoEm_Out;
import com.ais.webservice.service.csr.d_getccs_limitba.D_GetCCSLimitBa;
import com.ais.webservice.service.csr.d_getccs_limitba.Fml32_D_GetCCSLimitBa_Out;
import com.ais.webservice.service.d_getcusivrpwd.D_GetCusIvrpwd;
import com.ais.webservice.service.d_getcusivrpwd.Fml32_D_GetCustIVRPwd_Out;
import com.ais.webservice.service.data3g.inquiry_counter.InquiryCounterService;
import com.ais.webservice.service.data3g.inquiry_counter.ProductResponse;
import com.ais.webservice.service.data3g.inquiry_permission.InquiryPermission;
import com.ais.webservice.service.data3g.inquiry_permission.InquiryPermissionResult;
import com.ais.webservice.service.data3g.unlock_permission.UnlockPermissionService;
import com.ais.webservice.service.etws_reversal.ETWS_Reversal;
import com.ais.webservice.service.etws_reversal.ReversalRequest;
import com.ais.webservice.service.etws_reversal.ReversalResponse;
import com.ais.webservice.service.evivussdsimdsaota.EvIVUSSDSIMDSAOTA;
import com.ais.webservice.service.evivussdsimdsaota.SffResponse;
import com.ais.webservice.service.inquiry_handset_profile.HandsetProfileResult;
import com.ais.webservice.service.inquiry_handset_profile.InquiryHandsetProfile;
import com.ais.webservice.service.interaction_campaign.InteractionCampaign;
import com.ais.webservice.service.interaction_campaign.OBJResponse;
import com.ais.webservice.service.model.WSObject;
import com.ais.webservice.service.model.webservice.*;
import com.ais.webservice.service.model.webservice.o2c.*;
import com.ais.webservice.service.model.webservice.payment.A_ConfPMPayModel;
import com.ais.webservice.service.model.webservice.payment.IPayServiceModel;
import com.ais.webservice.service.model.webservice.prepaid.*;
import com.ais.webservice.service.o2c.a_chkppivr.A_CHKPPIVR;
import com.ais.webservice.service.o2c.a_chkppivr.Fml32_A_ChkPPIVR_Out;
import com.ais.webservice.service.o2c.a_confppregft.A_ConfPPRegFt;
import com.ais.webservice.service.o2c.a_confppregft.Fml32_A_ConfPPRegFt_Out;
import com.ais.webservice.service.o2c.a_confppuregft.A_ConfPPURegFt;
import com.ais.webservice.service.o2c.a_confppuregft.Fml32_A_ConfPPURegFt_Out;
import com.ais.webservice.service.o2c.a_getppmbmgt.A_GetPPMbMgt;
import com.ais.webservice.service.o2c.a_getppmbmgt.Fml32_A_GetPPMbMgt_Out;
import com.ais.webservice.service.o2c.check_change_service.EvOMServiceCheckChangeService;
import com.ais.webservice.service.o2c.confirm_change_service.EvOMServiceConfirmChangeService;
import com.ais.webservice.service.o2c.get_offerfor_mobileno.GetOfferMobileNo;
import com.ais.webservice.service.o2c.get_offerfor_mobileno.Response;
import com.ais.webservice.service.o2c.query_asset_register_status.EvOMServiceQueryAssetRegisterStatus;
import com.ais.webservice.service.o2c.query_masscommon_accountinfo.EvESeServiceQueryMassCommonAccountInfo;
import com.ais.webservice.service.o2c.updateInteractResponseIVR.UpdateInteractResponse;
import com.ais.webservice.service.payment.a_confpmpay.A_ConfPMPay;
import com.ais.webservice.service.payment.a_confpmpay.Fml32_A_ConfPMPay_Out;
import com.ais.webservice.service.payment.a_lstpm_mobdtl.A_LstPMMobDtl;
import com.ais.webservice.service.payment.a_lstpm_mobdtl.Fml32_A_LstPMMobDtl_Out;
import com.ais.webservice.service.payment.d_getpm_cc_accbal.D_GetPMCCAccBal;
import com.ais.webservice.service.payment.d_getpm_cc_accbal.Fml32_D_GetPMCCAccBal_Out;
import com.ais.webservice.service.payment.d_getpm_ccver.D_GetPMCCVer;
import com.ais.webservice.service.payment.d_getpm_ccver.Fml32_D_GetPMCCVer_Out;
import com.ais.webservice.service.payment.ipayservice.IPayProcessResponse;
import com.ais.webservice.service.payment.ipayservice.IPayService;
import com.ais.webservice.service.popular_campaign.ListPopularCampaign;
import com.ais.webservice.service.popular_campaign.PopularCampaignService;
import com.ais.webservice.service.prepaid.a_chkpp_on_demand.A_ChkPPOnDemand;
import com.ais.webservice.service.prepaid.a_chkpp_on_demand.Fml32_A_ChkPPOnDemand_Out;
import com.ais.webservice.service.prepaid.a_chkpp_simprof.A_ChkPPSIMProf;
import com.ais.webservice.service.prepaid.a_chkpp_simprof.Fml32_A_ChkPPSIMProf_Out;
import com.ais.webservice.service.prepaid.a_conf_ppchg_sord.A_ConfPPChgSOrd;
import com.ais.webservice.service.prepaid.a_conf_ppchg_sord.Fml32_A_ConfPPChgSOrd_Out;
import com.ais.webservice.service.prepaid.a_getpp_addres.A_GetPPAddrES;
import com.ais.webservice.service.prepaid.a_getpp_addres.Fml32_A_GetPPAddrES_Out;
import com.ais.webservice.service.prepaid.a_getppchg_sord.A_GetPPChgSOrd;
import com.ais.webservice.service.prepaid.a_getppchg_sord.Fml32_A_GetPPChgSOrd_Out;
import com.ais.webservice.service.prepaid.a_subs_ppunl_acc.A_SubsPPUnLkAcc;
import com.ais.webservice.service.prepaid.a_subs_ppunl_acc.Fml32_A_SubsPPUnLkAcc_Out;
import com.ais.webservice.service.prepaid.d_getppai_scrdsv.D_GetPPAISCrdSv;
import com.ais.webservice.service.prepaid.d_getppai_scrdsv.Fml32_D_GetPPAISCrdSv_Out;
import com.ais.webservice.service.prepaid.d_getppm_bac3.D_GetPPMbAc3;
import com.ais.webservice.service.prepaid.d_getppm_bac3.Fml32_D_GetPPMbAc3_Out;
import com.ais.webservice.service.prepaid.d_getppmb_nost.D_GetPPMbNoSt;
import com.ais.webservice.service.prepaid.d_getppmb_nost.Fml32_D_GetPPMbNoSt_Out;
import com.ais.webservice.service.prepaid.d_lst_ppbtf.D_LstPPBTF;
import com.ais.webservice.service.prepaid.d_lst_ppbtf.Fml32_D_LstPPBTF_Out;
import com.ais.webservice.service.prepaid.d_lst_ppmbft2.D_LstPPMbFt2;
import com.ais.webservice.service.prepaid.d_lst_ppmbft2.Fml32_D_LstPPMbFt2_Out;
import com.ais.webservice.service.prepaid.d_lst_pppck_trans.D_LstPPPckTrans;
import com.ais.webservice.service.prepaid.d_lst_pppck_trans.Fml32_D_LstPPPckTrans_Out;
import com.ais.webservice.service.prepaid.d_lst_pprcg.D_LstPPRcg;
import com.ais.webservice.service.prepaid.d_lst_pprcg.Fml32_D_LstPPRcg_Out;
import com.ais.webservice.service.prepaid.d_lst_ppsev_trans.D_LstPPSeVTrans;
import com.ais.webservice.service.prepaid.d_lst_ppsev_trans.Fml32_D_LstPPSeVTrans_Out;
import com.ais.webservice.service.prepaid.d_lstpp_simst.D_LstPPSimST;
import com.ais.webservice.service.prepaid.d_lstpp_simst.Fml32_D_LstPPSimSt_Out;
import com.ais.webservice.service.sff.esquery_cusprofile_forivracc.EvESQueryCusProfileForIVRACC;
import com.ais.webservice.service.sff.evivu_ssdsimd_saota.SFF_EvIVUSSDSIMDSAOTA;
import com.ais.webservice.service.sff.evom_request_suspend.EvOMRequestSuspendReconnect;
import com.ais.webservice.service.sff.evom_service_check_blacklist.EvOMServiceIVRCheckBlackList;
import com.ais.webservice.service.sff.evomnumber_reconnect_for_ivracc.EvOMNumberofReconnectforIVRACC;
import com.ais.webservice.service.sff.evomquery_sim_profile.EvOMQuerySIMProfile;
import com.ais.webservice.service.sff.evtm_unlock_fraudpp.EvTMUnLockFraudPP;
import com.ais.webservice.service.sftonline_billinginterface.BillingHeaderType;
import com.ais.webservice.service.sftonline_billinginterface.GetAccountBalanceRequestMessageType;
import com.ais.webservice.service.sftonline_billinginterface.GetAccountBalanceResponseMessageType;
import com.ais.webservice.service.sftonline_billinginterface.SFFToOnlineBillingService;
import com.ais.webservice.service.siebel.ais_insert_suppress_content.AISInsertSuppressContent;
import com.ais.webservice.service.siebel.ais_list_suppress_content.AISListSuppressContent;
import com.ais.webservice.service.siebel.ais_list_suppress_content.ListOfListSuppressContent;
import com.ais.webservice.service.siebel.ais_update_suppress_content.AISUpdateSuppressContent;
import com.ais.webservice.service.siebel.common_create_service_request.CommonCreateServiceRequest;
import com.ais.webservice.service.siebel.common_createactivity.CommonCreateActivity;
import com.ais.webservice.service.usmp.inquiry_subscriber_service.InquirySubscriberService;
import com.ais.webservice.service.usmp.inquiry_subscriber_service.SubscriberServiceResponse;
import com.ais.webservice.service.usmp.unregister_legacy_service.Status;
import com.ais.webservice.service.usmp.unregister_legacy_service.UnregisterLegacyService;
import com.ais.webservice.util.AISUtils;
import com.trues.webservice.config.ServiceConfig;
import com.trues.webservice.config.model.Env;
import com.trues.webservice.config.model.Environments;
import com.trues.webservice.config.model.Service;
import com.trues.webservice.config.model.WebServiceConfig;
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
public class AISWService {
    private static Logger logger = LoggerFactory.getLogger(AISWService.class);
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

            path = AISUtils.getConfigFile(null, DEFAULT_CONFIG_PATH, 0);
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

    public static WSObject<Fml32_A_GetCCCustInfo_Out> A_GetCCCusInfo1(String _sessionId, String mobileNo) {
        return A_GetCCCusInfo.A_GetCCCusInfo(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }

    public static WSObject<Webservice_acc_BindingQSServiceStub.Fml32_A_GetCCCustInfo_Out> A_GetCCCusInfo(String _sessionId, String mobileNo) {
        return A_GetCCCusInfo2.A_GetCCCusInfo(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }


    public static WSObject<Fml32_D_GetCustIVRPwd_Out> D_GetCustIVRPwd(String _sessionId, String mobileNo, String password) {
        return D_GetCusIvrpwd.D_GetCustIVRPwd(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, password);
    }

    public static WSObject<HandsetProfileResult> USMP_InquiryHandsetProfile(String _sessionId, UMSPInquiryHandsetProfileModel inParams) {
        return InquiryHandsetProfile.InquiryHandsetProfile(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<SffResponse> evIVUSSDSIMDSAOTA(String _sessionId, String mobileNo, String event) {
        return EvIVUSSDSIMDSAOTA.evIVUSSDSIMDSAOTA(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, event);
    }


    public static WSObject<ReversalResponse> ETWS_Reversal_Inquiry_Rom(String _sessionId, ReversalRequest request) {
        return ETWS_Reversal.ETWS_Reversal_Inquiry_Rom(_sessionId, activeEnv.getWebServiceConfig(), request);
    }

    public static WSObject<ReversalResponse> ETWS_Reversal_Rom_Topup(String _sessionId, ReversalRequest request) {
        return ETWS_Reversal.ETWS_Reversal_Rom_Topup(_sessionId, activeEnv.getWebServiceConfig(), request);
    }


    public static WSObject<GetAccountBalanceResponseMessageType> GetAccountBalance(String _sessionId, BillingHeaderType header,
                                                                                   GetAccountBalanceRequestMessageType message) {
        return SFFToOnlineBillingService.GetAccountBalance(_sessionId, activeEnv.getWebServiceConfig(), header, message);
    }


    public static WSObject<String> CommonCreateActivity(String _sessionId, GenActParams genActParams) {
        return CommonCreateActivity.CommonCreateActivity(_sessionId, activeEnv.getWebServiceConfig(), genActParams);
    }


    public static WSObject<ListOfListSuppressContent> AISListSuppressContent(String _sessionId, String mobileNo) {
        return AISListSuppressContent.AISListSuppressContent(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }

    public static WSObject<String> AISInsertSuppressContent(String _sessionId, AISInsertSuppressContentModel insertParam) {
        return AISInsertSuppressContent.AISInsertSuppressContent(_sessionId, activeEnv.getWebServiceConfig(), insertParam);
    }

    public static WSObject<String> AISUpdateSuppressContent(String _sessionId, AISInsertSuppressContentModel insertParam) {
        return AISUpdateSuppressContent.AISUpdateSuppressContent(_sessionId, activeEnv.getWebServiceConfig(), insertParam);
    }


    public static WSObject<CommonCreateServiceResponseModel> CommonCreateServiceRequest(String _sessionId, CommonCreateServiceRequestModel inParams) {
        return CommonCreateServiceRequest.CommonCreateServiceRequest(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<ADCResponseModel> ADC_RefillCard(String _sessionId, ADCModel inParams) {
        return RefillCard.ADC_RefillCard(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<ADCResponseModel> ADC_ResetPassword(String _sessionId, ADCModel inParams) {
        return ResetPassword.ADC_ResetPassword(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<ADCResponseModel> ADC_ResetPort(String _sessionId, ADCModel inParams) {
        return ResetPort.ADC_ResetPort(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<SubscriberServiceResponse> USMP_InquirySubscriberService(String _sessionId, UMSPInquirySubscriberModel inParams) {
        return InquirySubscriberService.USMP_InquirySubscriberService(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Status> USMP_UnregisterLegacyService(String _sessionId, UMSPUnregisterLegacyrModel inParams) {
        return UnregisterLegacyService.USMP_UnregisterLegacyService(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<InquiryPermissionResult> Data3G_InquiryPermission(String _sessionId, Data3gInquiryPermissionModel inParams) {
        return InquiryPermission.Data3G_InquiryPermission(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<com.ais.webservice.service.data3g.unlock_permission.Status> Data3G_UnlockPermissionService(String _sessionId, Data3gUnlockPermissionModel inParams) {
        return UnlockPermissionService.Data3G_UnlockPermissionService(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<ProductResponse> Data3G_InquiryCounter(String _sessionId, Data3gInquiryCounterModel inParams) {
        return InquiryCounterService.Data3G_InquiryCounter(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<com.ais.webservice.service.sff.esquery_cusprofile_forivracc.SffResponse> SFF_evESQueryCusProfileForIVRACC(String _sessionId, String mobileNo, String inOption) {
        return EvESQueryCusProfileForIVRACC.evESQueryCusProfileForIVRACC(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, inOption);
    }


    public static WSObject<com.ais.webservice.service.sff.evomnumber_reconnect_for_ivracc.SffResponse> SFF_evOMNumberofReconnectforIVRACC(String _sessionId, String mobileNo, String inOption) {
        return EvOMNumberofReconnectforIVRACC.evOMNumberofReconnectforIVRACC(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, inOption);
    }

    public static WSObject<com.ais.webservice.service.sff.evomquery_sim_profile.SffResponse> SFF_evOMQuerySIMProfile(String _sessionId, String mobileNo) {
        return EvOMQuerySIMProfile.evOMQuerySIMProfile(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }


    public static WSObject<com.ais.webservice.service.sff.evtm_unlock_fraudpp.SffResponse> SFF_evTMUnLockFraudPP(String _sessionId, String mobileNo, String userId) {
        return EvTMUnLockFraudPP.evTMUnLockFraudPP(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, userId);
    }

    public static WSObject<com.ais.webservice.service.sff.evom_service_check_blacklist.SffResponse> SFF_evOMServiceIVRCheckBlackList(String _sessionId, String orderType, String IDCardNo) {
        return EvOMServiceIVRCheckBlackList.evOMServiceIVRCheckBlackList(_sessionId, activeEnv.getWebServiceConfig(), orderType, IDCardNo);
    }

    public static WSObject<com.ais.webservice.service.sff.evivu_ssdsimd_saota.SffResponse> SFF_evIVUSSDSIMDSAOTA(String _sessionId, String mobileNo) {
        return SFF_EvIVUSSDSIMDSAOTA.evIVUSSDSIMDSAOTA(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }

    public static WSObject<com.ais.webservice.service.sff.evom_request_suspend.SffResponse> SFF_evOMRequestSuspendReconnect(String _sessionId, SFFPostPaidSuspendModel inParams) {
        return EvOMRequestSuspendReconnect.evOMRequestSuspendReconnect(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_DCUpdAutoEm_Out> CSR_A_DCUpdAutoEm(String _sessionId, String DCC_BILLING_ACC_NUM, String DCC_USER_ID, String DCC_EFFECTIVE_DAT) {
        return A_DCUpdAutoEm.A_DCUpdAutoEm(_sessionId, activeEnv.getWebServiceConfig(), DCC_BILLING_ACC_NUM, DCC_USER_ID, DCC_EFFECTIVE_DAT);
    }

    public static WSObject<Fml32_D_GetCCSLimitBa_Out> CSR_D_GetCCSLimitBa(String _sessionId, String CSR_BILLING_ACCOUNT_NO, String CSR_SERVICE_OPTION) {
        return D_GetCCSLimitBa.D_GetCCSLimitBa(_sessionId, activeEnv.getWebServiceConfig(), CSR_BILLING_ACCOUNT_NO, CSR_SERVICE_OPTION);
    }

    public static WSObject<OBJResponse> InteractionCampaign(String _sessionId, String mobile) {
        return InteractionCampaign.InteractionCampaign(_sessionId, activeEnv.getWebServiceConfig(), mobile);
    }


    public static WSObject<Fml32_D_GetPMCCVer_Out> Payment_D_GetPMCCVer(String _sessionId, String PM_BILLING_ACC_NUM, String PM_CREDIT_CARD_NUM,
                                                                        String PM_EXPIRED_DATE, String PM_SERVICE_OPTION) {
        return D_GetPMCCVer.D_GetPMCCVer(_sessionId, activeEnv.getWebServiceConfig(), PM_BILLING_ACC_NUM, PM_CREDIT_CARD_NUM, PM_EXPIRED_DATE, PM_SERVICE_OPTION);
    }

    public static WSObject<Fml32_D_GetPMCCAccBal_Out> Payment_D_GetPMCCAccBal(String _sessionId, String PM_BILLING_ACC_NUM, String PM_SERVICE_OPTION) {
        return D_GetPMCCAccBal.D_GetPMCCAccBal(_sessionId, activeEnv.getWebServiceConfig(), PM_BILLING_ACC_NUM, PM_SERVICE_OPTION);
    }

    public static WSObject<Fml32_A_LstPMMobDtl_Out> Payment_A_LstPMMobDtl(String _sessionId, String PM_MOBLIE_NUM, String PM_3G_FLAG, String PM_BILLING_ACC_NUM) {
        return A_LstPMMobDtl.A_LstPMMobDtl(_sessionId, activeEnv.getWebServiceConfig(), PM_MOBLIE_NUM, PM_3G_FLAG, PM_BILLING_ACC_NUM);
    }

    public static WSObject<Fml32_A_ConfPMPay_Out> Payment_A_ConfPMPay(String _sessionId, A_ConfPMPayModel in) {
        return A_ConfPMPay.A_ConfPMPay(_sessionId, activeEnv.getWebServiceConfig(), in);
    }

    public static WSObject<IPayProcessResponse> Payment_IPayService(String _sessionId, IPayServiceModel in) {
        return IPayService.IPayService(_sessionId, activeEnv.getWebServiceConfig(), in);
    }

    public static WSObject<Fml32_A_GetPPAddrES_Out> Prepaid_A_GetPPAddrES(String _sessionId, A_GetPPAddrESModel inParams) {
        return A_GetPPAddrES.A_GetPPAddrES(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_LstPPBTF_Out> Prepaid_D_LstPPBTF(String _sessionId, D_LstPPBTFModel inParams) {
        return D_LstPPBTF.D_LstPPBTF(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }


    public static WSObject<Fml32_A_GetPPChgSOrd_Out> Prepaid_A_GetPPChgSOrd(String _sessionId, A_GetPPChgSOrdModel inParams) {
        return A_GetPPChgSOrd.A_GetPPChgSOrd(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_ConfPPChgSOrd_Out> Prepaid_A_ConfPPChgSOrd(String _sessionId, A_ConfPPChgSOrdModel inParams) {
        return A_ConfPPChgSOrd.A_ConfPPChgSOrd(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_LstPPMbFt2_Out> Prepaid_D_LstPPMbFt2(String _sessionId, D_LstPPMbFt2Model inParams) {
        return D_LstPPMbFt2.D_LstPPMbFt2(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_GetPPAISCrdSv_Out> Prepaid_D_GetPPAISCrdSv(String _sessionId, D_GetPPAISCrdSvModel inParams) {
        return D_GetPPAISCrdSv.D_GetPPAISCrdSv(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_ChkPPSIMProf_Out> Prepaid_A_ChkPPSIMProf(String _sessionId, A_ChkPPSIMProfModel inParams) {
        return A_ChkPPSIMProf.A_ChkPPSIMProf(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_ChkPPOnDemand_Out> Prepaid_A_ChkPPOnDemand(String _sessionId, A_ChkPPOnDemandModel inParams) {
        return A_ChkPPOnDemand.A_ChkPPOnDemand(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_SubsPPUnLkAcc_Out> Prepaid_A_SubsPPUnLkAcc(String _sessionId, A_SubsPPUnLkAccModel inParams) {
        return A_SubsPPUnLkAcc.A_SubsPPUnLkAcc(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_GetPPMbNoSt_Out> Prepaid_D_GetPPMbNoSt(String _sessionId, D_GetPPMbNoStModel inParams) {
        return D_GetPPMbNoSt.D_GetPPMbNoSt(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }


    public static WSObject<Fml32_D_LstPPPckTrans_Out> Prepaid_D_LstPPPckTrans(String _sessionId, D_LstPPPckTransModel inParams) {
        return D_LstPPPckTrans.D_LstPPPckTrans(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_LstPPSeVTrans_Out> Prepaid_D_LstPPSeVTrans(String _sessionId, D_LstPPSeVTransModel inParams) {
        return D_LstPPSeVTrans.D_LstPPSeVTrans(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }


    public static WSObject<Fml32_D_LstPPRcg_Out> Prepaid_D_LstPPRcg(String _sessionId, D_LstPPRcgModel inParams) {
        return D_LstPPRcg.D_LstPPRcg(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_GetPPMbAc3_Out> Prepaid_D_GetPPMbAc3(String _sessionId, D_GetPPMbAc3Model inParams) {
        return D_GetPPMbAc3.D_GetPPMbAc3(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_D_LstPPSimSt_Out> Prepaid_D_LstPPSimST(String _sessionId, D_LstPPSimSTModel inParams) {
        return D_LstPPSimST.D_LstPPSimST(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<ListPopularCampaign> PopularCampaigns(String _sessionId, PopularCampaign inParams) {
        return PopularCampaignService.PopularCampaigns(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }


    public static WSObject<Fml32_A_ChkPPIVR_Out> O2C_A_CHKPPIVR(String _sessionId, A_CHKPPIVRModel inParams) {
        return A_CHKPPIVR.A_CHKPPIVR(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_ConfPPRegFt_Out> O2C_A_ConfPPRegFt(String _sessionId, A_ConfPPRegFtModel inParams) {
        return A_ConfPPRegFt.A_ConfPPRegFt(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_ConfPPURegFt_Out> O2C_A_ConfPPURegFt(String _sessionId, A_ConfPPRegFtModel inParams) {
        return A_ConfPPURegFt.A_ConfPPURegFt(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Fml32_A_GetPPMbMgt_Out> O2C_A_GetPPMbMgt(String _sessionId, A_GetPPMbMgtModel inParams) {
        return A_GetPPMbMgt.A_GetPPMbMgt(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<com.ais.webservice.service.o2c.check_change_service.SffResponse> O2C_EvOMServiceCheckChangeService(String _sessionId, String mobileNo, String serviceCode,
                                                                                                                              String orderChannel) {
        return EvOMServiceCheckChangeService.evOMServiceCheckChangeService(_sessionId, activeEnv.getWebServiceConfig(), mobileNo, serviceCode, orderChannel);
    }


    public static WSObject<com.ais.webservice.service.o2c.query_asset_register_status.SffResponse> O2C_EvOMServiceQueryAssetRegisterStatus(String _sessionId, String mobileNo) {
        return EvOMServiceQueryAssetRegisterStatus.evOMServiceQueryAssetRegisterStatus(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }


    public static WSObject<com.ais.webservice.service.o2c.query_masscommon_accountinfo.SffResponse> O2C_EvESeServiceQueryMassCommonAccountInfo(String _sessionId, String inMobileNo,
                                                                                                                                               String option) {
        return EvESeServiceQueryMassCommonAccountInfo.evESeServiceQueryMassCommonAccountInfo(_sessionId, activeEnv.getWebServiceConfig(), inMobileNo, option);
    }

    public static WSObject<com.ais.webservice.service.o2c.confirm_change_service.SffResponse> O2C_EvOMServiceConfirmChangeService(String _sessionId, OMServiceConfirmChangeService inParams) {
        return EvOMServiceConfirmChangeService.evOMServiceConfirmChangeService(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<Response> O2C_GetOfferForMobileNo(String _sessionId, GetOfferMobileModel inParams) {
        return GetOfferMobileNo.getOfferForMobileNo(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }

    public static WSObject<com.ais.webservice.service.o2c.updateInteractResponseIVR.Response> O2C_UpdateInteractResponseIVR(String _sessionId, String mobileNo) {
        return UpdateInteractResponse.updateInteractResponseIVR(_sessionId, activeEnv.getWebServiceConfig(), mobileNo);
    }





   /* public static double CheckPayPerUse(String _sessionId, String ) {
        logger.info(_sessionId + " : " + ">>>>>>>>>>>>>>> call <<<<<<<<<<<<<<<<<<<<<<<");
        return D_LstPPSimST.D_LstPPSimST(_sessionId, activeEnv.getWebServiceConfig(), inParams);
    }*/


}
