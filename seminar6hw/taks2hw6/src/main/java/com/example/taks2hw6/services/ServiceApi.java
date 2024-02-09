package com.example.taks2hw6.services;

import com.example.taks2hw6.domain.Characters;
import com.example.taks2hw6.domain.Result;

public interface ServiceApi {

    Characters getAllCharacters();
    Result getCharacter();

}
