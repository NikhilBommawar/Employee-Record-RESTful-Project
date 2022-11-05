package com.example;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetail {

	private Date timestamp;
	private String errormsg;
	private String path;
}
