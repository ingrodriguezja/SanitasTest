package com.test.sanitas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.sanitas.dto.BasicResponseDto;
import com.test.sanitas.dto.DataDto;
import com.test.sanitas.dto.ResponseDto;
import com.test.sanitas.service.CalculatorService;

import io.corp.calculator.TracerImpl;


@Controller
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;


	@RequestMapping(value="/add",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicResponseDto> add(@Valid @RequestBody DataDto data, HttpServletRequest request, HttpServletResponse response) {
		ResponseDto operation = new ResponseDto();
		BasicResponseDto resp = new BasicResponseDto();
		TracerImpl tracer =new TracerImpl();
		try {
			operation= calculatorService.add(data,response);
			if (operation!=null) {

				resp.setMessage("The result of the operation is: "+operation.getNumResult());
				resp.setNumResult(operation.getNumResult());

			}
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			tracer.trace(e);
			resp.setMessage("An error has occurred");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/substract",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicResponseDto> substract(@Valid @RequestBody DataDto data, HttpServletRequest request, HttpServletResponse response) {
		ResponseDto operation = new ResponseDto();
		BasicResponseDto resp = new BasicResponseDto();
		TracerImpl tracer =new TracerImpl();
		try {
			operation= calculatorService.substract(data,response);
			if (operation!=null) {

				resp.setMessage("The result of the operation is: "+operation.getNumResult());
				resp.setNumResult(operation.getNumResult());

			}
			return new ResponseEntity<>(resp, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			tracer.trace(e);
			resp.setMessage("An error has occurred");
			return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
