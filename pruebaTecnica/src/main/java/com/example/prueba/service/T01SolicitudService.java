package com.example.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.T01SolicitudEntity;
import com.example.prueba.repository.T01SolicitudRepository;

@Service
public class T01SolicitudService {
	
	@Autowired
	private T01SolicitudRepository solicitudRepo;
	
	private List<T01SolicitudEntity> lista;
	
	public ResponseEntity<T01SolicitudEntity> registrar(T01SolicitudEntity solicitud) throws Exception{
		BigDecimal valorMonto = BigDecimal.valueOf(100000);
		Date fechaActual = null;
		
		lista = listarPorCliente(solicitud.getIdCliente());
		if (lista.isEmpty()) {
			if (solicitud.getMonto().compareTo(valorMonto)>0) {
				if (solicitud.getFechaIngreso().getTime()>=fechaActual.getTime()) {
					solicitudRepo.save(solicitud);
				}
			}else {
				System.out.print("El monto debe ser superior a 1 millon");
			}
		}else {
			throw new Exception("No se permite más de una solicitud por cliente", null);
		}
		return new ResponseEntity<T01SolicitudEntity>(solicitud, HttpStatus.CREATED);
	}
	
	public ResponseEntity<T01SolicitudEntity> Actualizar(T01SolicitudEntity solicitud){
		solicitudRepo.save(solicitud);
		return new ResponseEntity<T01SolicitudEntity>(solicitud, HttpStatus.OK);
	}
	
	public List<T01SolicitudEntity> listarPorId(int idSolicitud){
		List<T01SolicitudEntity> listaId =null;
		try {
			listaId = solicitudRepo.findByIdSolicitud(idSolicitud);
			if (listaId.isEmpty()) {
				throw new Exception("No se encontro registro para el id de solicitud" + idSolicitud);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaId;
	}
	
	public List<T01SolicitudEntity> listarPorCliente(String idCliente){
		List<T01SolicitudEntity> listaCliente =null;
		try {
			listaCliente = solicitudRepo.findByIdCliente(idCliente);
			if (listaCliente.isEmpty()) {
				System.out.println("No Encontro registro para el cliente "+idCliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCliente;
	}
	
	public void eliminar(int idSolicitud){
		List<T01SolicitudEntity> resultado = listarPorId(idSolicitud);
		if (resultado!=null) {
			solicitudRepo.deleteById(idSolicitud);;
		}
	}
}
