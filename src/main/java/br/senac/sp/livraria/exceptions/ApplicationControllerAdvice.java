package br.senac.sp.livraria.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class ApplicationControllerAdvice {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions (MethodArgumentNotValidException ex){    // nome padrão "handleValidationExceptions"

        Map<String, String> errorJson = new HashMap<>(); // não pode ter chaves iguais

       for (ObjectError error : ex.getAllErrors()){
           FieldError fieldError = (FieldError) error;
           String campo = fieldError.getField();
           System.out.println(campo + " - " + error.getDefaultMessage());
           errorJson.put(campo, error.getDefaultMessage());
       }
        return ResponseEntity.ok(errorJson);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> teste (RuntimeException ex){
        return ResponseEntity.ok("Erro de Execução!");
    }

}
