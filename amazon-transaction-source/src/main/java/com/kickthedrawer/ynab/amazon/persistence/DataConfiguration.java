package com.kickthedrawer.ynab.amazon.persistence;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.kickthedrawer.ynab.amazon.persistence.repositories" })
@EnableAutoConfiguration
public class DataConfiguration {

}
