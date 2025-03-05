package com.example.devOpsPersonInfo.api.controllers;

import com.example.devOpsPersonInfo.business.abstracts.PersonService;
import com.example.devOpsPersonInfo.business.dtos.requests.CreatePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.DeletePersonRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.GetPersonByIdRequest;
import com.example.devOpsPersonInfo.business.dtos.requests.UpdatePersonRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CreatePersonRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError());
        }
        return ResponseEntity.ok(personService.add(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeletePersonRequest request) {
        return ResponseEntity.ok(personService.delete(request));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody UpdatePersonRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError());
        }
        return ResponseEntity.ok(personService.update(request));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestBody GetPersonByIdRequest request) {
        return ResponseEntity.ok(personService.getById(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }
}

