package it.lucagobbi.includo;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.RemoteIpValve;
import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.ajp.AbstractAjpProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IncludoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(IncludoApplication.class, args);
    }

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        Connector httpConnector = new Connector("HTTP/1.1");
        httpConnector.setPort(9090);
        httpConnector.setSecure(false);
        httpConnector.setAllowTrace(false);
        httpConnector.setScheme("http");
        tomcat.addAdditionalTomcatConnectors(httpConnector);
        return tomcat;
    }

}
