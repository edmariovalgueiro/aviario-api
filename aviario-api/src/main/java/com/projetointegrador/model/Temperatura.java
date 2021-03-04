package com.projetointegrador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Temperatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTemperatura;
	
	private int idGalpao;
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

	public int getIdGalpao() {
		return idGalpao;
	}

	public void setIdGalpao(int idGalpao) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_hora == null) ? 0 : data_hora.hashCode());
		result = prime * result + idGalpao;
		result = prime * result + ((idTemperatura == null) ? 0 : idTemperatura.hashCode());
		long temp;
		temp = Double.doubleToLongBits(temperatura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(umidade);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
