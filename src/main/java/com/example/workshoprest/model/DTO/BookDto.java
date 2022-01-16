package com.example.workshoprest.model.DTO;

public class BookDto {

    private String id;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private double findPerDay;
    private String description;

    public BookDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    public double getFindPerDay() {
        return findPerDay;
    }

    public void setFindPerDay(double findPerDay) {
        this.findPerDay = findPerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
