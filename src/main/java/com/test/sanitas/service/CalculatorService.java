package com.test.sanitas.service;

import javax.servlet.http.HttpServletResponse;

import com.test.sanitas.dto.DataDto;
import com.test.sanitas.dto.ResponseDto;

public interface CalculatorService {

	ResponseDto add(DataDto data, HttpServletResponse response);

	ResponseDto substract(DataDto data, HttpServletResponse response);

}
