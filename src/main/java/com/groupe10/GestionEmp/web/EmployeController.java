package com.groupe10.GestionEmp.web;

import com.groupe10.GestionEmp.entité.Employe;
import com.groupe10.GestionEmp.entité.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeController {
    @Autowired private EmpService service;
    @GetMapping("/employe")
    public List<Employe> showEmpList(Model model){
        List<Employe> emps =  service.listAll();
        model.addAttribute( "listEmployes", listEmp());
        return emps;
    }
    @GetMapping("/employe/new")
    public String ShowNewForm(Model model){
        model.addAttribute( "employe", new Employe());
        model.addAttribute("pageTitle", "Ajouter un employé");
        return emp_form;
    }
    @PostMapping("/employe/save")
    public String saveEmp(Employe employe){
        service.save(employe);
        return "redirect:/employe";
    }

    @GetMapping("/employe/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id , Model model){
        Employe emp = service.get(id);
        model.addAttribute("employe", emp);
        model.addAttribute("pageTitle", "Modifier un employé (ID "+id+ ")");
        return "redirect:/employe";
    }

    @GetMapping("/employe/delete/{id}")
    public String deleteEmp(@PathVariable("id") Integer id , Model model){
        Employe emp = service.delete(id);
        model.addAttribute("employe", emp);
        model.addAttribute("pageTitle", "Supprimer un employé (ID "+id+ ")");
        return "redirect:/employe";
    }

    public EmployeController(EmpService service) {
        this.service = service;
    }
}
