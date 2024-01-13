package br.com.mike.vaga.configuration;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.UserTransaction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
@ApplicationScoped
public class ConfigurationUserTransaction {

    @Resource
    private UserTransaction userTransaction;

    @Bean
    @TransactionScoped
    public UserTransaction userTransaction() {
        return userTransaction;
    }

    public UserTransaction getUserTransaction() {
        return userTransaction;
    }
}
