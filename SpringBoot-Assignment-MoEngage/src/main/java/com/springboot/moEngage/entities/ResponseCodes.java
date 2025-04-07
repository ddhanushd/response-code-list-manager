package com.springboot.moEngage.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "response_codes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseCodes {

	@Id
	private String code;
	private String imageUrl;
}
