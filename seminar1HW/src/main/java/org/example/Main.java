package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.*;

public class Main {
    /*
Создать проект с использованием Maven или Gradle, добавить в него несколько
зависимостей и написать код, использующий эти зависимости.
Задание:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
     */
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");
        Person person1 = new Person("Vasily", "Ivanov", 25);
        Person person2 = new Person("Vasily", "Ivanov", 26);
        System.out.println(person1);
        System.out.println(person1.hashCode());
        if (person1.equals(person2)) {
            System.out.println(person1 + " и " + person2 + " - один и тот же человек.");
        } else {
            System.out.println(person1 + " и " + person2 + " - разные люди.");
        }

        System.out.println();
        System.out.println("Вариант1 сериализации/десериализации");
        System.out.println("Сериализация в строку JSON =>");
        Gson gson = new Gson();
        String gsonString = gson.toJson(person1);
        System.out.println(gsonString);
        System.out.println("Десериализация строки JSON обратно в объект Person =>");
        Person person3 = gson.fromJson(gsonString, Person.class);
        System.out.println(person3);

        System.out.println();
        System.out.println("Вариант2 сериализации/десериализации");
        System.out.println("Сериализация в строку JSON =>");
        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(stringWriter, person2);
        File file = new File("person.json");
        objectMapper.writeValue(file, person2);
        System.out.println(stringWriter);

        System.out.println("Десериализация строки JSON обратно в объект Person =>");
//        Object o = (new JsonParser().parse(new FileReader("person.json")));
//        System.out.println(o);
        Person person4 = objectMapper.readValue(file, Person.class);
        System.out.println(person4);
    }
}