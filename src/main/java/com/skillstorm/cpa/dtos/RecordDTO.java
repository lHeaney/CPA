package com.skillstorm.cpa.dtos;

//This is a Data Transfer Object designed to hold the values of a Record, which is a single filing in our application
public record RecordDTO(int id, String owner, String type, double total_revenue, double taxes_owed, double taxes_paid, String status) {}
