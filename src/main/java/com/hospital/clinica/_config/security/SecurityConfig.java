package com.hospital.clinica._config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// Esto toma los valores del application.properties
	@Value("${security.signing-key}")
	private String signingKey;

	@Value("${security.encoding-strength}")
	private Integer encodingStrength;

	@Value("${security.security-realm}")
	private String securityRealm; //

	// Esto toma los valores del applicaion.properties en la parde de datasources
	// (base de datos)
	// @Autowired
	// private javax.sql.DataSource dataSource;

	// Esto es para ligar la tabla de usuarios con el login, especificar que los
	// usuarios los o login los tome o haga con
	// una tabla de nuestro modelo
	@Autowired
	private UserDetailsService userDetailsService;

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);// .passwordEncoder(passwordEncoder());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic()
				.realmName(securityRealm).and().csrf() // deshabilita el token por defecto que brind spring para darle
														// paso a JWT
				.disable();
	}

	// Esto es para saber la firma de token (algo como que tipo de encriptacion etc)
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(signingKey);
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter()); // Esto es para guardar en token en memoria
		// return new JdbcTokenStore(this.dataSource); // Esto es para guardar el token
		// en base de datos
	}

	@Bean
	@Primary // Que este sea el primer Bean que se ejecute
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore()); // El lugar donde se guardaran los token
		defaultTokenServices.setSupportRefreshToken(true); // Que se puedan generar nuevos token
		defaultTokenServices.setReuseRefreshToken(false); // Que no permita la reutilización de tokens refrescados
		return defaultTokenServices;

	}

	// ESTO SOLO ES PARA EJEMPLOS DE UTILIZAR USUARIOS EN MEMORIA, COMO SI LOS
	// DECLARARAMOS DIRECTO EN EL PROPERTIES
	/*
	 * @Override protected void configure (AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("usuario").password("password"); }
	 */

}
