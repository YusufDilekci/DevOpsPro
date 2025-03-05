package com.example.devOpsPersonInfo.business.dtos.requests;

import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeletePersonRequest {

    @NotNull
    private int id;
}

