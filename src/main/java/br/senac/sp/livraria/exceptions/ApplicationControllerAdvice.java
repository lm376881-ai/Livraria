package br.senac.sp.livraria.exceptions;


import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorJson);   // como chamar o erro e médoto criado a cima
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> teste (RuntimeException ex){
        return ResponseEntity.ok("Erro de Execução!");
    }

}
