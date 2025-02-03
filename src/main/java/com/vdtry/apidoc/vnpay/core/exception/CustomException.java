package com.vdtry.apidoc.vnpay.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomException extends RuntimeException{
    HttpStatusCode httpStatusCode;
    String errorCode;
    String message;
    Map<String, Object> details;
}
