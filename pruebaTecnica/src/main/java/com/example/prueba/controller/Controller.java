package com.example.prueba.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.prueba.entity.T01SolicitudEntity;
import com.example.prueba.service.FechasService;
import com.example.prueba.service.T01SolicitudService;

@RestController
@RequestMapping("/prueba")
public class Controller {
	
	@Autowired
	private T01SolicitudService solicitudService;
	@Autowired
	private FechasService fechasService;
	
	@PostMapping("/registrarSolicitud")
	public ResponseEntity<T01SolicitudEntity> registrarSolicitud(@RequestBody  T01SolicitudEntity solicitud) throws Exception{
		solicitudService.registrar(solicitud);
		return new ResponseEntity<T01SolicitudEntity>(solicitud, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaSolicitud")
	public ResponseEntity<T01SolicitudEntity> actualizar(@RequestBody T01SolicitudEntity solicitud){
		solicitudService.Actualizar(solicitud);
		return new ResponseEntity<T01SolicitudEntity>(solicitud, HttpStatus.OK);
	}
	
	@GetMapping("/listarPorId")
	public List<T01SolicitudEntity> listar(@Param("idSolicitud") int idSolicitud){
		List<T01SolicitudEntity> list =solicitudService.listarPorId(idSolicitud);
		return list; 
	}
	
	@GetMapping("/listaPorIdCliente")
	public List<T01SolicitudEntity> listarIdCliente(@Param("idCliente") String idCliente){
		List<T01SolicitudEntity> list =solicitudService.listarPorCliente(idCliente);
		return list; 
	}
	
	@DeleteMapping("/eliminarSolicitud")
	public void eliminarSolicitud(@Param("idSolicitud") int idSolicitud) {
		solicitudService.eliminar(idSolicitud);
	}
	
	
	
	@PostMapping("/promedioFechas")
	public void promedio(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin) {
		fechasService.promedioFechas(fechaInicio, fechaFin);
	}
}
