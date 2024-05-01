package com.proyecto.cafeteria.controllers;

import com.proyecto.cafeteria.models.CafeModel;
import com.proyecto.cafeteria.services.CafeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CafeController {
    @Autowired
    CafeServices cafeServices;

    @PostMapping()
    public CafeModel saveCustomer(@RequestBody CafeModel customer){
        return cafeServices.saveCustomer(customer);
    }
    @PutMapping()
    public CafeModel editCustomer(@RequestBody CafeModel customer){
        return cafeServices.editCustomer(customer);
    }

    @GetMapping()
    public ArrayList<CafeModel> getAllCustomer(){
        return cafeServices.getAllCustomer();
    }


    @GetMapping("/findCustomerById/{id}")
    public Optional<CafeModel> findCustomerById(@PathVariable Long id){
        return cafeServices.findCustomerById(id);
    }

    @GetMapping("/findCustomerByEmail/{email}")
    public Optional<ArrayList<CafeModel>> findCustomerByEmail(@PathVariable String email){
        return cafeServices.findCustomerByEmail(email);
    }


    @GetMapping("/findCustomerByName/{name}")
    public Optional<ArrayList<CafeModel>> findCustomerByName(@PathVariable String name){
        return cafeServices.findCustomerByName(name);
    }
    @DeleteMapping("/delete-customer-by-id")
    public String deleteCustomerById(@RequestParam("id") Long id){
        return cafeServices.deleteCustomerById(id);
    }
}
