package com.example.devOpsPersonInfo.business.concretes;

import com.example.devOpsPersonInfo.business.abstracts.PersonService;
import com.example.devOpsPersonInfo.business.dtos.requests.CreatePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.DeletePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.GetPersonByIdRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.UpdatePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.responses.*;
import com.example.devOpsPersonInfo.core.mappers.ModelMapperService;
import com.example.devOpsPersonInfo.entities.Person;
import com.example.devOpsPersonInfo.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonManager implements PersonService {

    private PersonRepository personRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllPersonsResponse> getAll() {
        List<Person> persons = personRepository.findAll();
        return persons.stream()
                .map(person -> modelMapperService.forResponse()
                        .map(person, GetAllPersonsResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CreatedPersonResponse add(CreatePersonRequest request) {
        Person person = modelMapperService.forRequest().map(request, Person.class);
        Person savedPerson = personRepository.save(person);
        return modelMapperService.forResponse().map(savedPerson, CreatedPersonResponse.class);
    }

    @Override
    public UpdatedPersonResponse update(UpdatePersonRequest request) {
        Person person = modelMapperService.forRequest().map(request, Person.class);
        Person updatedPerson = personRepository.save(person);
        return modelMapperService.forResponse().map(updatedPerson, UpdatedPersonResponse.class);
    }

    @Override
    public DeletedPersonResponse delete(DeletePersonRequest request) {
        var person = personRepository.findById(request.getId()).orElseThrow();
        personRepository.deleteById(request.getId());
        return modelMapperService.forResponse().map(person, DeletedPersonResponse.class);
    }

    @Override
    public GetPersonByIdResponse getById(GetPersonByIdRequest request) {
        Person person = personRepository.findById(request.getId()).orElseThrow();
        return modelMapperService.forResponse().map(person, GetPersonByIdResponse.class);
    }
}

