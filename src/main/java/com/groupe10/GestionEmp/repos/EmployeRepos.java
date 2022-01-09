package com.groupe10.GestionEmp.repos;


import com.groupe10.GestionEmp.entité.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class EmployeRepos implements JpaRepository<Employe, Long> {

    @Autowired
    private EmployeRepos EmpRep;

    @RequestMapping(value="/form",method= RequestMethod.GET)
    public String formEmploye(Model model) {
        model.addAttribute("employe",new Employe());
        return "formEmploye";
    }


}
