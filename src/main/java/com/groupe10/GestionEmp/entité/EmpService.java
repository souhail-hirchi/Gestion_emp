package com.groupe10.GestionEmp.entité;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired private EmpRepository repo;

    public List<Employe> listAll(){
        return (List<Employe>) repo.findAll();
    }

    public String save(Employe employe){
        repo.save(employe);
        return "redirect:/employe";
    }

    public Employe get(Integer id){
        Optional<Employe> resultat= repo.findById(id);
        return resultat.get();
    }

    public Employe delete(Integer id){
        repo.deleteById(id);
        return null;
    }
}
