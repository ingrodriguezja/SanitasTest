package com.test.sanitas.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DataDto {

	@NotNull(message="Data of 'nums' couldn't be null")
	@Size(min = 2, message="There is not enough data to calculate the operation")
    private List<Integer> nums;
    
}
