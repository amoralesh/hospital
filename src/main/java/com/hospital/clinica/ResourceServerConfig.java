package com.hospital.clinica;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private ResourceServerTokenServices tokenServices;
	
	//Obtener los datos de applicaion.properties
	@Value("${security.jwt.resource-ids}")
	private String resourceIds;
	
	
	//Aqui seguimos configurando el properties pasandole parametros
	@Override
	public void configure (ResourceServerSecurityConfigurer resources) throws Exception{
		resources.resourceId(resourceIds).tokenServices(tokenServices);
	}
	
	
	
	public void configure(HttpSecurity http) throws Exception{
		http
		.exceptionHandling().authenticationEntryPoint((AuthenticationEntryPoint) new com.hospital.clinica.AuthException())
		.and()
		.requestMatchers()
		.and()
		.authorizeRequests()
		.antMatchers("/doctores/doctor").authenticated();
	}

}
