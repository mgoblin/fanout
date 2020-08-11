package ru.mg.fanout;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import ru.mg.accountservice.AccountDetailsRequest;
import ru.mg.accountservice.AccountDetailsResponse;
import ru.mg.accountservice.AccountService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@SpringBootApplication
public class Application {

    private static final String DELAYED_SERVICE_URL = "http://localhost:8080/service/accounts/delayed";
    private static final String FAST_SERVICE_URL = "http://localhost:8080/service/accounts/fast";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean("delayedAccountWSClient")
    public AccountService delayedAccountServiceClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AccountService.class);
        jaxWsProxyFactoryBean.setAddress(DELAYED_SERVICE_URL);
        return (AccountService) jaxWsProxyFactoryBean.create();
    }

    @Bean("fastAccountWSClient")
    public AccountService fastAccountServiceClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AccountService.class);
        jaxWsProxyFactoryBean.setAddress(FAST_SERVICE_URL);
        return (AccountService) jaxWsProxyFactoryBean.create();
    }

    @Bean("request")
    public JAXBContext rqContext() throws JAXBException {
        return JAXBContext.newInstance(AccountDetailsRequest.class);
    }

    @Bean("response")
    public JAXBContext rsContext() throws JAXBException {
        return JAXBContext.newInstance(AccountDetailsResponse.class);
    }

    @Bean("fastWebClient")
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(FAST_SERVICE_URL)
                .build();
    }
}
