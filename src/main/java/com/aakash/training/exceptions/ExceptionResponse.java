package com.aakash.training.exceptions;

import java.util.Date;

public class ExceptionResponse {

    private String description;
    private String message;
    private Date dateAndTime;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String description, String message, Date dateAndTime) {
        this.description = description;
        this.message = message;
        this.dateAndTime = dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
