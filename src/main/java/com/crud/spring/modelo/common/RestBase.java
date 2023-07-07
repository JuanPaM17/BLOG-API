/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.spring.modelo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author sarit
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestBase {
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date timestamp = new Date();
    private Object response;

    public RestBase() {
    }

    public RestBase(Object response) {
        this.response = response;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RestBase{" + "response=" + response + '}';
    }
    
    
}
