package com.example.davrtest.dto;

public class UserStatusUpdateDto {
    private Long id;
    private String previousStatus;
    private String currentStatus;

    public UserStatusUpdateDto(Long id, String previousStatus, String currentStatus) {
        this.id = id;
        this.previousStatus = previousStatus;
        this.currentStatus = currentStatus;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
