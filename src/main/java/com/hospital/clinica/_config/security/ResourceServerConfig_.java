package com.hospital.clinica._config.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;

//@Configuration
//@EnableResourceServer
public class ResourceServerConfig_ extends ResourceServerConfigurerAdapter {

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
		.exceptionHandling().authenticationEntryPoint((AuthenticationEntryPoint) new com.hospital.clinica._config.security.AuthException())
		.and()
		.requestMatchers()
		.and()
		.authorizeRequests()
		.antMatchers("/pacientes/**").authenticated()
		.antMatchers("/doctores/**").authenticated()
		.antMatchers("/areas/**").authenticated()
		.antMatchers("/consultas/**").authenticated()
		.antMatchers("/direcciones/**").authenticated()
		.antMatchers("/especialidades/**").authenticated()
		 .antMatchers("/imagenes/**").authenticated()
		.antMatchers("/modoaplicacion/**").authenticated()
		.antMatchers("/periodos/**").authenticated()
		//.antMatchers("/usuarios/**").authenticated()
		.antMatchers("/tratamientos/**").authenticated();
		
	}

}
