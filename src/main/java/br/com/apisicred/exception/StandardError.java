package br.com.apisicred.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandardError implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Integer status;
    private String msg;
    private LocalDateTime timeStamp;
}