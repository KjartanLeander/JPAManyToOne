package com.example.jpamanytoone.service;

import com.example.jpamanytoone.model.Kommune;
import com.example.jpamanytoone.repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {
        private final RestTemplate restTemplate;

        String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

        @Autowired
        KommuneRepository kommuneRepository;

    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

        private void saveKommuneer(List<Kommune> kommuneer) {kommuneer.forEach(reg -> kommuneRepository.save(reg));}

    @Override
    public List<Kommune> getKommuner() {
        List<Kommune> lst = new ArrayList<>();
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>(){
                        });
        List<Kommune> kommuneer = kommuneResponse.getBody();
        saveKommuneer(kommuneer);
        return kommuneer;
    }
}

