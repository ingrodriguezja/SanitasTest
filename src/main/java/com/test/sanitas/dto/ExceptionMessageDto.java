package com.test.sanitas.dto;

import lombok.Data;

@Data	
public class ExceptionMessageDto {

	private String date;
	private String message;
	private String error;
	private String path;
}
