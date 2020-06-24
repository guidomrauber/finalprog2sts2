package com.example.main.entity;

import com.example.main.exception.InputValidationException;

public interface DetectorMutante {
	boolean isMutant(String[] param) throws InputValidationException;
}
