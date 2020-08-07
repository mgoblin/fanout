package ru.mg.fanout;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.mg.accountservice.AccountService;

@SpringBootApplication
public class Application {

    private static final String DELAYED_SERVICE_URL = "http://localhost:8080/service/accounts/delayed";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean("delayedAccountWSClient")
    public AccountService accountServiceClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(AccountService.class);
        jaxWsProxyFactoryBean.setAddress(DELAYED_SERVICE_URL);
        return (AccountService) jaxWsProxyFactoryBean.create();
    }
}
