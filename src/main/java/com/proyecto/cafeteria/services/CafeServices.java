package com.proyecto.cafeteria.services;

import com.proyecto.cafeteria.models.CafeModel;
import com.proyecto.cafeteria.repositories.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CafeServices {
    @Autowired
    CafeRepository cafeRepository;

    public CafeModel saveCustomer(CafeModel customer){
        if(cafeRepository.findCustomerModelByEmail(customer.getEmail()).toString().equals("Optional[[]]")){
            return cafeRepository.save(customer);
        }else{
            CafeModel customerError = new CafeModel();
            customerError.setId(-1L);
            return customerError;
        }
    }

    public ArrayList<CafeModel> getAllCustomer(){
        return(ArrayList<CafeModel>) cafeRepository.findAll();
    }

    public Optional<CafeModel> findCustomerById(Long id){
        return cafeRepository.findById(id);
    }

    public CafeModel editCustomer(CafeModel customer){
        return cafeRepository.save(customer);
    }

    public String deleteCustomerById(Long id){
        if(findCustomerById(id).isPresent()){
            cafeRepository.deleteById(id);
            return "customer deleted successfully";
        }else {
            return "customer with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<CafeModel>> findCustomerByName(String name){
        return cafeRepository.findCustomerModelByName(name);
    }

    public Optional<ArrayList<CafeModel>> findCustomerByEmail(String email){
        return cafeRepository.findCustomerModelByEmail(email);
    }
}
