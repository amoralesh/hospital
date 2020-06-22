package com.hospital.clinica._config.security.nuevo.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import com.hospital.clinica._config.security.AuthException;



 
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	Logger logger = LoggerFactory.getLogger(ResourceServerConfig.class);

    @Value("${security.jwt.resource-id}")
    private String resourceIds;
 
    @Value("${oauth2.unprotected-paths}") 
    private String[] unProtectedPaths;

    @Value("${oauth2.swagger-paths}") 
    private String[] swagger;
    
	@Autowired
    private ResourceServerTokenServices tokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(resourceIds).tokenServices(tokenServices);
    } 
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling()
		.authenticationEntryPoint(new AuthException()) 
	    .and()
		   .authorizeRequests()
		     .antMatchers( unProtectedPaths ).permitAll()
		    
		   .and()
		   .authorizeRequests()

	        // SWAGGER
	        .antMatchers( swagger ).hasAuthority("web:administracion:mantenimiento:swagger")
	        
	        // USUARIOS PUBLICOS 
	        .antMatchers( HttpMethod.POST , "/usuarios/publico/filtro" ).hasAuthority("web:administracion:usuarios:publicos:mostrar")
	        .antMatchers( HttpMethod.GET ,"/usuarios/publico" , "/usuarios/publico/{id:\\\\d+}" ).hasAuthority("web:administracion:usuarios:publicos:mostrar")
	        .antMatchers( HttpMethod.POST ,"/usuarios/publico" ).hasAuthority("web:administracion:usuarios:publicos:crear")
	        .antMatchers( HttpMethod.PUT ,"/usuarios/publico" , "/usuarios/publico/{id:\\d+}" ).hasAuthority("web:administracion:usuarios:publicos:actualizar")
	        .antMatchers( HttpMethod.DELETE , "/usuarios/publico/{id:\\d+}" ).hasAuthority("web:administracion:usuarios:publicos:borrar")
	          
	        // USUARIOS ADMINISTADORES 
	        .antMatchers( HttpMethod.POST , "/usuarios/admin/filtro" ).hasAuthority("web:administracion:usuarios:admin:mostrar")
	        .antMatchers( HttpMethod.GET ,"/usuarios/admin" , "/usuarios/admin/{id:\\\\d+}" ).hasAuthority("web:administracion:usuarios:admin:mostrar")
	        .antMatchers( HttpMethod.POST ,"/usuarios/admin" ).hasAuthority("web:administracion:usuarios:admin:crear")
	        .antMatchers( HttpMethod.PUT ,"/usuarios/admin" , "/usuarios/admin/{id:\\d+}" ).hasAuthority("web:administracion:usuarios:admin:actualizar")
	        .antMatchers( HttpMethod.DELETE , "/usuarios/admin/{id:\\d+}" ).hasAuthority("web:administracion:usuarios:admin:borrar")
	         
	        // PERMISOS ADMINISTADORES
	        .antMatchers( HttpMethod.POST , "/permisos/admin/filtro" ).hasAuthority("web:administracion:permisos:admin:mostrar")
	        .antMatchers( HttpMethod.GET ,"/permisos/admin" , "/permisos/admin/{id:\\\\d+}" ).hasAuthority("web:administracion:permisos:admin:mostrar")
	        .antMatchers( HttpMethod.POST ,"/permisos/admin" ).hasAuthority("web:administracion:permisos:admin:crear")
	        .antMatchers( HttpMethod.PUT ,"/permisos/admin" , "/permisos/admin/{id:\\d+}" ).hasAuthority("web:administracion:permisos:admin:actualizar")
	        .antMatchers( HttpMethod.DELETE , "/permisos/admin/{id:\\d+}" ).hasAuthority("web:administracion:permisos:admin:borrar")
	        
	        // SESIONES 
	        .antMatchers( HttpMethod.POST , "/sesiones/filtro" ).hasAuthority("web:administracion:sesiones:mostrar")
	        .antMatchers( HttpMethod.POST , "/sesiones/token" ).hasAuthority("web:administracion:sesiones:cerrar")

	        // LOG
	        .antMatchers( "/log/*" ).hasAuthority("web:administracion:log:todos")

	        // CLIENTE DETALLE 
	        .antMatchers( "/cliente/detalle/**" ).hasAuthority("web:administracion:cliente:detalle:todos")

	        // CLIENTE TOKEN 
	        .antMatchers( "/cliente/token/**" ).hasAuthority("web:administracion:cliente:token:todos")
	         
	        // BD 
	        .antMatchers( "/database/**" ).hasAuthority("web:administracion:basedatos:todos")
  
		    .anyRequest().authenticated()
		    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();  
    }

 
}