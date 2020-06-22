package com.hospital.clinica._config.security.nuevo.custom;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.jboss.jandex.TypeTarget.Usage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.hospital.clinica.dao.UsuarioDao;
import com.hospital.clinica.model.Usuario;


public class CustomTokenEnhancer implements TokenEnhancer {

	Logger logger = LoggerFactory.getLogger(CustomTokenEnhancer.class);

	@Autowired
	public UsuarioDao usuarioPublicoDao;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		String usuario = authentication.getPrincipal().toString();
		Usuario usuarioPublico = usuarioPublicoDao.findOnByUsername(usuario);

		DefaultOAuth2AccessToken defaultOAuth2AccessToken = ((DefaultOAuth2AccessToken) accessToken);
		final Map<String, Object> additionalInfo = new HashMap<>();
		additionalInfo.put("apellidos", usuarioPublico.getApellidoP());


		defaultOAuth2AccessToken.setAdditionalInformation(additionalInfo);
		return accessToken;
	}

}