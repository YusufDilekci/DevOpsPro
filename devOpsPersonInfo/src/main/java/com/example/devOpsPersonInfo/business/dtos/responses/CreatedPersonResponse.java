package com.example.devOpsPersonInfo.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPersonResponse {
    private int id;
    private String name;
    private String address;
}
