package com.example.task2hw6add.servises;

import com.example.task2hw6add.domain.Characters;
import com.example.task2hw6add.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceApiImpl implements ServiceApi {

    //    класс-обертка для работы с внешними Api
    @Autowired
    private RestTemplate template;
    //    возможность чтения и формирования заголовков http
    @Autowired
    private HttpHeaders headers;

    @Value("${external.api.url}")
    private String apiUrl;

    @Value("${pagination.perPage}")
    private int paginationPerPage;

    @Override
    public Characters getAllCharacters() {
        return null;
    }

    @Override
    public Result getCharacterById(Integer id) {
        return null;
    }

    @Override
    public Characters getCharactersWithPage(String page) {
        return null;
    }

    @Override
    public int getPageNumberById(int id) {
        return 0;
    }

    @Override
    public Characters getFilteredCharacters(String name, String status, String species, String type, String gender) {
        return null;
    }
}
