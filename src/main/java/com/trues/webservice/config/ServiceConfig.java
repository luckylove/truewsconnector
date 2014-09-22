package com.trues.webservice.config;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.converters.extended.NamedMapConverter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.trues.webservice.config.model.*;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class ServiceConfig /*extends AbstractRulesModule */{

    private static Environments  environments;

   /* @Override
    protected void configure()
    {
        forPattern( "resources/environments" ).createObject().ofType( Environments.class ).then()
                .setProperties();
        forPattern( "resources/environments/env").createObject().ofType(Env.class).then().setProperties().then().setNext("addEnv");
        forPattern("resources/environments/env/webService").createObject().ofType(WebServiceConfig.class).then().setNext("setWebServiceConfig");
        forPattern("resources/environments/env/webService/service").createObject().ofType(Service.class).then().setProperties().then().setNext("addService");
        forPattern("resources/environments/env/webService/service/endpoint").setBeanProperty();
        forPattern("resources/environments/env/webService/service/username").setBeanProperty();
        forPattern("resources/environments/env/webService/service/password").setBeanProperty();
        forPattern("resources/environments/env/webService/service/params/param").createObject().ofType(Param.class).then().setProperties().then().setNext("addParam");
    }*/

    public static Environments parse(InputStream inputStream) throws IOException, SAXException {
        XStream xstream = new XStream(new StaxDriver());
        xstream.ignoreUnknownElements();
        //xstream.processAnnotations(Config.class);
        xstream.alias("resources", Resources.class);
        xstream.alias("environments", Environments.class);
        xstream.useAttributeFor(Environments.class, "active");
        xstream.addImplicitMap(Environments.class, "envs", "env", Env.class, "name");
        xstream.useAttributeFor(Env.class, "name");
        xstream.aliasField("webService", Env.class, "webServiceConfig");
        xstream.alias("webService", WebServiceConfig.class);
        xstream.addImplicitMap(WebServiceConfig.class, "serviceMap", "service", Service.class, "name");
        xstream.useAttributeFor(Service.class, "name");
        xstream.aliasField("params", Service.class, "innerParams");
        xstream.registerConverter(new NamedMapConverter(xstream.getMapper(), "param", "name", String.class, "value",
                String.class, true, true, xstream.getConverterLookup()));

        Resources environments = (Resources)xstream.fromXML(inputStream);
        ServiceConfig.environments = environments.getEnvironments();

       /* DigesterLoader loader = newLoader( new ServiceConfig() )
                .setNamespaceAware( true )
                .setXIncludeAware( true );
        Digester digester = loader.newDigester();
        ServiceConfig.environments = digester.parse(inputStream);*/
        return  ServiceConfig.environments;
    }
}
