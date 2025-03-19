package com.skillstorm.cpa.dtos;


public record RecordDTO(int id, String owner, String type, double total_revenue, double taxes_owed, double taxes_paid, String status) {}
