package com.hospital.clinica.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hospital.clinica._config.security.nuevo.modelo.OauthClientDetails;

 
public interface OauthClientDetailsDao extends JpaRepository<OauthClientDetails, String>{

	
	@Query( "FROM OauthClientDetails oauthCD WHERE oauthCD.id =:client_id" )
	OauthClientDetails findByClientId( @Param("client_id")  String client_id);

	@Query( "FROM OauthClientDetails oauthCD WHERE oauthCD.resource_ids =:resource_ids" )
	List<OauthClientDetails> findByResourceId(@Param("resource_ids") String resource_ids);
 

	
}
