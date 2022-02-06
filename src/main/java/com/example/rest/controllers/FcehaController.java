package com.example.rest.controllers;
import com.example.rest.model.FechaModel;
import com.example.rest.Json.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fecha")
public class FcehaController {
	@PostMapping
	public jsonResult postFecha(String dato1,String dato2) {
		String [] vect = dato1.split(":");
		LocalDateTime d = LocalDateTime.of(2022, 02, 06,Integer.parseInt(vect[0]), Integer.parseInt(vect[0]), Integer.parseInt(vect[0]), 0);
		ZoneId z31 = ZoneId.ofOffset("UTC", ZoneOffset.of(dato2));
		ZonedDateTime zon = d.atZone(z31);
		//TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		//Instant hor = Instant.parse("2018-11-30T18:35:24.00Z");
		//LocalTime localTime=LocalTime.ofInstant(hor, z31);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String formattedTime=zon.format(formatter);
		FechaModel dat= new FechaModel();
		dat.setHora(formattedTime);
		dat.setTimezone("UTC");
		return jsonResult.ok(dat);
	}
}
