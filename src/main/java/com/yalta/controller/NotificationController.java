//package com.yalta.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class NotificationController {
//
//    @GetMapping("/foo")
//    public ResponseEntity<String> notification(@RequestParam("id") int id) {
//        System.out.println(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//}