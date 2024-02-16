package com.example.task2hw6add.servises;

import com.example.task2hw6add.domain.Characters;
import com.example.task2hw6add.domain.Result;

public interface ServiceApi {

    public Characters getAllCharacters();

    public Result getCharacterById(Integer id);

    public Characters getCharactersWithPage(String page);

    public int getPageNumberById(int id);

    public Characters getFilteredCharacters(
            String name, String status, String species,
            String type, String gender);
}
