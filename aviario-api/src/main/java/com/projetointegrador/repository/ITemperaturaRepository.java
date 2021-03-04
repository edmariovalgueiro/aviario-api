package com.projetointegrador.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Temperatura;

@Repository
public interface ITemperaturaRepository extends JpaRepository<Temperatura, Long> {

		@Query(
			value = "SELECT * FROM (SELECT * FROM Temperatura WHERE data_hora BETWEEN :startDate AND :endDate) u WHERE u.id_galpao = :id_galpao",
			nativeQuery = true)
	public List<Temperatura> getAllBetweenDates(@Param("startDate")Timestamp startDate, @Param("endDate")Timestamp endDate, @Param("id_galpao") Long id_galpao);  	
}
