package com.proyecto.cafeteria.repositories;

import com.proyecto.cafeteria.models.CafeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CafeRepository extends CrudRepository<CafeModel, Long> {

    public Optional<ArrayList<CafeModel>> findCustomerModelByEmail(String email);
    public Optional<ArrayList<CafeModel>> findCustomerModelByName(String name);
}
