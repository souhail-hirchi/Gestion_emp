package com.groupe10.GestionEmp.entité;

import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Employe, Integer> {

    public long countById(Integer id);
}
