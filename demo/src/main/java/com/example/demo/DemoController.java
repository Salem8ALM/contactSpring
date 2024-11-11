package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DemoController {

List<Contact> contacts = new ArrayList();

    @PostMapping("/addContact")
    String contact (@RequestBody Contact contact) {
         if (contact.getName() == null || contact.getEmail() == null || contact.getPhone() == null) {
             return "failed to add contact";

         } else {
             contacts.add(contact);
             return "Contact added successfully!";
         }
     }

     @GetMapping ("/getContactDetails")
    String recieve (@RequestParam String name){
        for(Contact contact : contacts){
            if(contact.getName().equals(name)){
                return contact.toString();
            }
        }
        return "Contact not found.";
     }




        //add the object in the list
         // use response entity . satus(httpstatus.ok) for checking if it went through
//        if (contact.getName() == null){
//            return "returned successfully";
//        }






}
