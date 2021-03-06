package com.example.prueba.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.prueba.entity.T01SolicitudEntity;
import com.example.prueba.repository.T01SolicitudRepository;

@Service
public class FechasService {
	
	@Autowired
	private T01SolicitudRepository soliRepo;
	int count;
	
	public void promedioFechas(Date fechaInicio, Date fechaFin) {
		List<T01SolicitudEntity> lista =soliRepo.findByFechaIngreso(fechaInicio,fechaFin);
		for (T01SolicitudEntity t01SolicitudEntity : lista) {
			count++;
			BigDecimal valorPromedio = lista.get(0).getMonto();
			int valor = valorPromedio.intValue() / count;
			System.out.print(valor);
		}
	}
}
