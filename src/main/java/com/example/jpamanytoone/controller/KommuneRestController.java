package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.KommuneRepository;
import com.example.jpamanytoone.service.ApiServiceGetKommuner;
import com.example.jpamanytoone.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class KommuneRestController {

    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    KommuneRepository kommuneRepository;

    @GetMapping("/getkommuner")
    public List<Kommune>getKommuner() {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }
    @PutMapping("/kommuner")
    public Kommune putKommune(@RequestBody Kommune kommune){
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }
    @PostMapping("/kommuner")
    @ResponseStatus(HttpStatus.CREATED)
    public Kommune postKommune(@RequestBody Kommune kommune){
        System.out.println(kommune);
        return kommuneRepository.save(kommune);
    }

    @DeleteMapping("/kommune")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKommune(@RequestBody Kommune kommune){
        kommuneRepository.delete(kommune);
        System.out.println(kommune + " Deleted");
    }
}

