package com.example.prueba.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.prueba.entity.T01SolicitudEntity;

@Repository
public interface T01SolicitudRepository extends JpaRepository<T01SolicitudEntity, Integer>{
	
	List<T01SolicitudEntity> findByIdSolicitud(Integer idSolicitud);
	
	List<T01SolicitudEntity> findByIdCliente(String idCliente);
	
	@Query(value = "SELECT * FROM T01_SOLICITUD WHERE FECHA_INGRESO BETWEEN ?  AND ? ",nativeQuery = true )
	List<T01SolicitudEntity> findByFechaIngreso(Date fechaIngreso, Date fechaFin);
}
