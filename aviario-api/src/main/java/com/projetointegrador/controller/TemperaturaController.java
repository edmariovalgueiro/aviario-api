package com.projetointegrador.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetointegrador.model.Temperatura;
import com.projetointegrador.repository.ITemperaturaRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/temperaturas")
public class TemperaturaController {

	@Autowired
	private ITemperaturaRepository repository;
	
	@PostMapping
	public boolean cadastrarTemperatura(
			@RequestParam(name="idGalpao", required = true, defaultValue = "0")Long idGalpao,
			@RequestParam(name="temp", required = true, defaultValue = "0.0")Double temp,
			@RequestParam(name="umid", required = true, defaultValue = "0.0")Double umid) {
	
		Temperatura temperatura;
		
		 try {
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
			 LocalDateTime now = LocalDateTime.now();  
			 String data_hora = dtf.format(now);
			 Timestamp instant = Timestamp.valueOf(data_hora);

			 temperatura = new Temperatura();
			 temperatura.setIdGalpao(idGalpao);
			 temperatura.setTemperatura(temp);
			 temperatura.setUmidade(umid);
			 temperatura.setData_hora(instant);
		 }
		 catch(Exception e){
			 System.out.println("Campos inválidos!");
			 return false;
		 }
	
		if (repository.save(temperatura) != null) {
			System.out.println("Sucesso na operação!");	
			return true;
		}
	
		System.out.println("Falha na operação!");	
		return false;
	}
	
	@GetMapping
	public List<Temperatura> recuperarTemperaturas(
			@RequestParam(name="idGalpao", required = true, defaultValue = "0")Long idGalpao, 
			@RequestParam(name="data_hora_ini", required = true, defaultValue = "0")Timestamp data_hora_ini, 
			@RequestParam(name="data_hora_fim", required = true, defaultValue = "0")Timestamp data_hora_fim) {
		
		List<Temperatura> temperaturas = new ArrayList<>();
		
		try {
			temperaturas = repository.getAllBetweenDates(data_hora_ini, data_hora_fim, idGalpao);
		}
		catch (Exception e) {
			System.out.println("Falha na operação!");
		}
		
		System.out.println("Sucesso na operação!");
		return temperaturas;
	}
}
