package com.groupe10.GestionEmp;
import com.groupe10.GestionEmp.entité.Employe;
import com.groupe10.GestionEmp.repos.EmployeRepos;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class EmpRepositoryTest {
    @Autowired
    private EmployeRepos repo;
    @Test
    //Test de l'ajout
    public void testAddNew(){
        Employe emp = new Employe();
        emp.setEmail("hirchisouhail@gmail.com");
        emp.setFonction("Developpeur");
        emp.setId(1);
        emp.setNom("Hirchi Souhail");

        Employe savedEmp = repo.save(emp);
        Assertions.assertThat(savedEmp).isNotNull();
        Assertions.assertThat(savedEmp.getId()).isGreaterThan(0);
    }
    @Test
    //Test de Lister
    public void testLitAll(){
        Iterable<Employe> employes = repo.findAll();
        Assertions.assertThat(employes).hasSizeGreaterThan(0);
    }
    @Test
    //Test de modifier
    public void testUpdate(){
        Integer empId = 1;
        Optional<Employe> optionalEmploye = repo.findById(empId);
        Employe emp = optionalEmploye.get();
        emp.setFonction("Commercial");
        repo.save(emp);

        Employe updateEmp = repo.findById(empId).get();
        Assertions.assertThat(updateEmp.getFonction()).isEqualTo("Commercial");
    }
    @Test
    //Test de Getter
    public void testGet(){
        Integer empId = 2;
        Optional<Employe> optionalEmploye = repo.findById(empId);
        Assertions.assertThat(optionalEmploye).isPresent();
        System.out.println(optionalEmploye.get());
    }
    @Test
    //Test de Suppression
    public void testDelete(){
        Integer empId = 2;
        repo.deleteById(empId);
        Optional<Employe> optionalEmploye = repo.findById(empId);
        Assertions.assertThat(optionalEmploye).isNotPresent();
    }

}
