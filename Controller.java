package com.example.HelloWorld;

import Model.UserResponse;
import Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Model.User;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Calendar;
import java.time.Period;
import java.util.Map;

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

    /* @PostMapping("/users")
    public ResponseEntity printUser(@RequestBody User user){
        //System.out.println("Printing Object User Name : " + user.getName() + ", location: " +user.getLocation())+ ;
        //return "Berhasil! Data user "+ user.getName() + ", location: " +user.getLocation())+ ;
       Calendar kalender = Calendar.getInstance();
        int tahun_sekarang = kalender.get(Calendar.YEAR);
        user.setName(user.getName()+" tambahan");
        user.setTahun_lahir(tahun_sekarang - user.getAge());
        return new ResponseEntity(user, HttpStatus.OK);
    } */

    /*@PostMapping("/users2")
    public ResponseEntity infoUser(@RequestBody User user){

        LocalDate today = LocalDate.now();
        UserResponse response = new UserResponse();
        response.setNama(user.getName());
        response.setAge(Period.between(user.getTahun_lahir(), today).getYears());
        response.setLocation(user.getLocation());
        return new ResponseEntity(response, HttpStatus.OK);
    }*/

    /* @PostMapping("/users3")
    public String konversi_tahun(@RequestBody User user){

        Calendar kalender = Calendar.getInstance();
        int tahun_sekarang = kalender.get(Calendar.YEAR);
        user.setAge(tahun_sekarang - user.getTahun_lahir());
        return "Your Age is " + user.getAge() ;

    } */

    @PostMapping("/users4")
    public ResponseEntity infoUser(@RequestBody User user){

        UserService service = new UserService();
        UserResponse response = service.modifyresponse(user);;
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @GetMapping("/test")
    public String testHeader(@RequestHeader String authorization){

        System.out.println(authorization);
        return "Success " + authorization;

    }

    @GetMapping("/test2")
    public String handleHeader(@RequestHeader Map<String, String > mapValues){

        return mapValues.toString();

    }
}
