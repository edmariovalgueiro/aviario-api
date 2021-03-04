package com.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "Temperatura")
public class Temperatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTemperatura;
	
	private Long idGalpao;
	private Timestamp data_hora;
	private double temperatura;
	private double umidade;
	
	public Temperatura() {}

	public Long getIdTemperatura() {
		return idTemperatura;
	}

	public void setIdTemperatura(Long idTemperatura) {
		this.idTemperatura = idTemperatura;
	}

	public Long getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(Long idGalpao) {
		this.idGalpao = idGalpao;
	}
	
	public java.sql.Timestamp getData_hora() {
		return data_hora;
	}

	public void setData_hora(java.sql.Timestamp data_hora) {
		this.data_hora = data_hora;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getUmidade() {
		return umidade;
	}

	public void setUmidade(double umidade) {
		this.umidade = umidade;
	}

	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temperatura other = (Temperatura) obj;
		if (data_hora == null) {
			if (other.data_hora != null)
				return false;
		} else if (!data_hora.equals(other.data_hora))
			return false;
		if (idGalpao != other.idGalpao)
			return false;
		if (idTemperatura == null) {
			if (other.idTemperatura != null)
				return false;
		} else if (!idTemperatura.equals(other.idTemperatura))
			return false;
		if (Double.doubleToLongBits(temperatura) != Double.doubleToLongBits(other.temperatura))
			return false;
		if (Double.doubleToLongBits(umidade) != Double.doubleToLongBits(other.umidade))
			return false;
		return true;
	}
}
