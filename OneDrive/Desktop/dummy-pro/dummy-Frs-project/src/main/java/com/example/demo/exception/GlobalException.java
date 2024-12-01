package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.dto.ResponseStructure;

@ControllerAdvice
public class GlobalException{
@ExceptionHandler(DataNotFoundException.class)

public ResponseEntity<ResponseStructure<String>> dataNotFoundExceptionHandler(DataNotFoundException dataNotFoundException){

ResponseStructure<String> responseStructure=new ResponseStructure<>();

responseStructure.setData("Data Not Found");

responseStructure.setMessage(dataNotFoundException.getMessage());

responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());

return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

}
}
