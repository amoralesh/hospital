package com.hospital.clinica.dao;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.clinica._config.security.nuevo.modelo.OauthClientToken;


public interface OauthClientTokenDao extends JpaRepository<OauthClientToken, String>{


	@Query( "FROM OauthClientToken oauthAT WHERE oauthAT.token_id =:token_id" )
	OauthClientToken findByTokenId(@Param("token_id") String token_id);

	@Query( "FROM OauthClientToken oauthAT WHERE oauthAT.user_name =:user_name" )
	List<OauthClientToken> findByUsername(@Param("user_name") String user_name);

	

	
}
