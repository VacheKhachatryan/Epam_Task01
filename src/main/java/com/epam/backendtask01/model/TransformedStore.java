package com.epam.backendtask01.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransformedStore extends Store{

    private Timestamp timestamp;

    public TransformedStore(String name, String[] items, Timestamp timestamp) {
        super(name, items);
        this.timestamp = timestamp;
    }
}