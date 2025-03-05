package com.example.devOpsPersonInfo.business.abstracts;

import com.example.devOpsPersonInfo.business.dtos.requests.CreatePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.DeletePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.GetPersonByIdRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.UpdatePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.responses.*;

import java.util.List;

public interface PersonService {
    CreatedPersonResponse add(CreatePersonRequest request);
    UpdatedPersonResponse update(UpdatePersonRequest request);
    DeletedPersonResponse delete(DeletePersonRequest request);
    List<GetAllPersonsResponse> getAll();
    GetPersonByIdResponse getById(GetPersonByIdRequest request);
}
