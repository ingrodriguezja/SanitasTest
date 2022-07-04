package com.test.sanitas.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.test.sanitas.dto.DataDto;
import com.test.sanitas.dto.ResponseDto;
import com.test.sanitas.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public ResponseDto add(DataDto data,HttpServletResponse response) {
		ResponseDto resp= new ResponseDto();
		try {
			resp.setMessage("OK");
			resp.setNumResult(2);
			return resp;
		}catch (Exception e){
			e.printStackTrace();
		}
		return resp;
	}

	@Override
	public ResponseDto substract(DataDto data, HttpServletResponse response) {
		ResponseDto resp= new ResponseDto();
		try {
			resp.setMessage("OK");
			resp.setNumResult(3);
			return resp;
		}catch (Exception e){
			e.printStackTrace();
		}
		return resp;
	}




}
