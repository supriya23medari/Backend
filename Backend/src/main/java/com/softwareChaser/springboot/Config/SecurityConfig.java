package com.softwareChaser.springboot.Config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.management.HttpSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Import(KeycloakSpringBootConfigResolver.class)
@EnableWebSecurity
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter
{
	
	
	  @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) {
	        SimpleAuthorityMapper grantedAuthorityMapper = new SimpleAuthorityMapper();
	        grantedAuthorityMapper.setPrefix("ROLE_");

	        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
	        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthorityMapper);
	        auth.authenticationProvider(keycloakAuthenticationProvider);
	    }

	    @Bean
	    @Override
	    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
	        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
	    }

	    @Bean
	    @Override
	    @ConditionalOnMissingBean(HttpSessionManager.class)
	    protected HttpSessionManager httpSessionManager() {
	        return new HttpSessionManager();
	    }
  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
      super.configure(http);
      http.authorizeRequests()
      .antMatchers("/manage/*").permitAll()
      .antMatchers("/api/get-quiz/","/swagger-ui/index.html/*","api/CategoryAndDifficulty/*","api/quiz-difficulty/*").hasAnyRole("user")
      .antMatchers("/api/save-quiz/","api/quiz-id/*","/api/quiz/*","/api/quiz-del/*","api/quiz-update/").hasAnyRole("admin")
      .antMatchers("/api/quiz-category/*").hasAnyRole("user","admin")
      .anyRequest()
      .permitAll();   
      http.csrf().disable();
  }
  
}