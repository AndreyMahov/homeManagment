//package com.mahov.homeManegment.config;
//
//import com.mahov.mvc.domain.enums.ExceptionMessage;
//import com.mahov.mvc.domain.exception.BookNotFoundException;
//import com.mahov.mvc.domain.exception.PersonNotFoundException;
//import com.mahov.mvc.domain.exception.RoleNotFoundException;
//import lombok.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(BookNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handlerBookNotFound(){
//        return ResponseEntity.badRequest().body(new ErrorResponse(ExceptionMessage.BOOK_NOT_FOUND.getMessage()));
//    }
//
//    @ExceptionHandler(PersonNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handlerPersonNotFound(){
//        return ResponseEntity.badRequest().body(new ErrorResponse(ExceptionMessage.PERSON_NOT_FOUND.getMessage()));
//    }
//
//    @ExceptionHandler(RoleNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handlerRoleNotFound(){
//        return ResponseEntity.badRequest().body(new ErrorResponse(ExceptionMessage.ROLE_NOT_EXIST.getMessage()));
//    }
//
//    @Value
//    public static class ErrorResponse {
//        String message;
//    }
//}
