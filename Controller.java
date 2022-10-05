package com.example.HelloWorld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Model.User;
import java.util.Calendar;

@RestController
public class Controller {

    @GetMapping("/control")
    public String control() {
        return "Hello World";
    }

    @GetMapping("/users/{userName}")
    public String printUserName(@PathVariable(name = "userName") String name){
        return "My Name is " + name ;
    }

    @GetMapping("/users/{name}/{age}/{location}")
    public String printUserInfo(@PathVariable String name,
                                @PathVariable Long age,
                                @PathVariable String location){
        return "My name is " + name + ". I am " + age + " years old. I am living in " + location;
    }
    // Post Mapping, Request Body, Input JSON Output JSON

    @PostMapping("/users")
    public ResponseEntity printUser(@RequestBody User user){
        //System.out.println("Printing Object User Name : " + user.getName() + ", location: " +user.getLocation())+ ;
        //return "Berhasil! Data user "+ user.getName() + ", location: " +user.getLocation())+ ;
       Calendar kalender = Calendar.getInstance();
        int tahun_sekarang = kalender.get(Calendar.YEAR);
        user.setName(user.getName()+" tambahan");
        user.setTahun_lahir(tahun_sekarang - user.getAge());
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping("/users2")
    public ResponseEntity infoUser(@RequestBody User user){

        Calendar kalender = Calendar.getInstance();
        int tahun_sekarang = kalender.get(Calendar.YEAR);
        user.setAge(tahun_sekarang - user.getTahun_lahir());
        return new ResponseEntity(user, HttpStatus.OK);

    }

}
