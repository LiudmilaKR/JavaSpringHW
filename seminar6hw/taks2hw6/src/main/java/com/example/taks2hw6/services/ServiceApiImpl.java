package com.example.taks2hw6.services;

import com.example.taks2hw6.domain.Characters;
import com.example.taks2hw6.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
//@AllArgsConstructor
public class ServiceApiImpl implements ServiceApi {

    //    класс-обертка для работы с внешними Api
    @Autowired
    private RestTemplate template;
    //    возможность чтения и формирования заголовков http
    @Autowired
    private HttpHeaders headers;


    private static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";

    @Override
    public Characters getAllCharacters() {
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Characters> response = template.exchange(CHARACTER_API,
                HttpMethod.GET, entity, Characters.class);
        return response.getBody();
    }

    @Override
    public Result getCharacter() {
        return null;
    }
}
