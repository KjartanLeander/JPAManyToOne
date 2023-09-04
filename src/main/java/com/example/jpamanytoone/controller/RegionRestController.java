package com.example.jpamanytoone.controller;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.model.Region;
import com.example.jpamanytoone.repository.KommuneRepository;
import com.example.jpamanytoone.repository.RegionRepository;
import com.example.jpamanytoone.service.ApiServiceGetRegioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegionRestController {

    @Autowired
    ApiServiceGetRegioner apiServiceGetRegioner;

    @Autowired
    RegionRepository regionRepository;

    @GetMapping("/getregioner")
    public List<Region> getRegioner() {
        List<Region> lstRegioner = apiServiceGetRegioner.getRegioner();
        return lstRegioner;
    }

    @PutMapping("/regioner")
    public Region putRegion(@RequestBody Region region){
        System.out.println(region);
        return regionRepository.save(region);
    }
    @PostMapping("/regioner")
    @ResponseStatus(HttpStatus.CREATED)
    public Region postRegion(@RequestBody Region region){
        System.out.println(region);
        return regionRepository.save(region);
    }

    @DeleteMapping("/region")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegion(@RequestBody Region region){
        regionRepository.delete(region);
        System.out.println(region + " Deleted");
    }
}
