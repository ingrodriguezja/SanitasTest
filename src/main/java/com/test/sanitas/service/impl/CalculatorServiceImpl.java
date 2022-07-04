package com.test.sanitas.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.test.sanitas.dto.DataDto;
import com.test.sanitas.dto.ResponseDto;
import com.test.sanitas.service.CalculatorService;

import io.corp.calculator.TracerImpl;

@Service
public class CalculatorServiceImpl implements CalculatorService {
	
	@Override
	public ResponseDto add(DataDto data,HttpServletResponse response) {
		ResponseDto resp= new ResponseDto();
		TracerImpl tracer =new TracerImpl();
		try {
			Integer result=0;
			for (int i=0;i<data.getNums().size();i++) {
				result=Math.addExact(data.getNums().get(i), result);
			}
			resp.setNumResult(result);

		}catch (Exception e){
			e.printStackTrace();
			tracer.trace(e);
		}
		tracer.trace(resp);
		return resp;
	}

	@Override
	public ResponseDto substract(DataDto data, HttpServletResponse response) {
		ResponseDto resp= new ResponseDto();
		TracerImpl tracer =new TracerImpl();
		try {
			Integer result=0;
			for (int i=0;i<data.getNums().size();i++) {
				if (i==0) {
					result=data.getNums().get(i);
				}else {
					result=Math.subtractExact(result,data.getNums().get(i));
				}
			}
			resp.setNumResult(result);
		}catch (Exception e){
			e.printStackTrace();
			tracer.trace(e);
		}
		tracer.trace(resp);
		return resp;
	}




}
