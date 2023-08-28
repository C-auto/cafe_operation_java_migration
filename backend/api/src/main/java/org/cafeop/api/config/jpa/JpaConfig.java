package org.cafeop.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@Configuration
@EntityScan(basePackages = "org.cafeop.db")
@EnableJpaRepositories(basePackages = "org.cafeop.db")
public class JpaConfig {
}
