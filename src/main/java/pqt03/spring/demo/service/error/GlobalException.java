package pqt03.spring.demo.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pqt03.spring.demo.domain.RestResponse;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = IdInvalidException.class)
    public ResponseEntity<RestResponse<Object>> handleIdException(IdInvalidException idException) {

        RestResponse<Object> res = new RestResponse<Object>();
        
        res.setEror(idException.getMessage());
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setMessage("Fail");


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
