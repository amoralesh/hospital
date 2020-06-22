package com.hospital.clinica.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.clinica._config.security.nuevo.modelo.OauthAccessToken;


public interface OauthAccessTokenDao extends JpaRepository<OauthAccessToken, String> {

	
	@Query("FROM OauthAccessToken oauthAT WHERE oauthAT.token_id =:token_id")
	OauthAccessToken findByTokenId(@Param("token_id") String token_id);

	@Query("FROM OauthAccessToken oauthAT WHERE oauthAT.user_name =:user_name")
	List<OauthAccessToken> findByUsername(@Param("user_name") String user_name);

}
