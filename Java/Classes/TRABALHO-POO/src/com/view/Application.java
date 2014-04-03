/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.view;

import com.controller.ConsultaController;
import com.controller.PacienteController;
import com.controller.ProntuarioController;
import com.domain.Consulta;
import com.domain.Medico;
import com.domain.Paciente;
import com.domain.Prontuario;
import com.domain.Secretaria;
import com.domain.Usuario;
import com.enums.Sexo;
import com.repository.Repository;
import com.repository.UserRepository;
import com.security.UserManager;
import com.view.controller.ConsultaViewController;
import com.view.controller.PacienteViewController;
import com.view.controller.ProntuarioViewController;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Gustavo
 */
public class Application {
    
    private static UserRepository generateUserRepositoy(){
    
        UserRepository userRepository = new UserRepository();
        
        Medico medico = new Medico();
        
        medico.setNome("Joao");
        medico.setCpf("0000000000");
        medico.setDataNascimento(new Date());
        medico.setSexo(Sexo.OUTROS);
        medico.setUser("jao");
        medico.setPassword("a");
        
        Secretaria secretaria = new Secretaria();
                
        secretaria.setNome("Ariadine");
        secretaria.setCpf("0000000000");
        secretaria.setDataNascimento(new Date());
        secretaria.setSexo(Sexo.MASCULINO);
        secretaria.setUser("ari");
        secretaria.setPassword("rihana");
        
        userRepository.merge(medico);
        userRepository.merge(secretaria);
        
        return userRepository;
    }
    
    public static void main(String[] args){
        
        UserManager userManager = new UserManager();
        userManager.setRepository(generateUserRepositoy());
        
        Login login = new Login(userManager);
        login.setVisible(true);
        
    }
    
    public static void buildLoggedScreen(Usuario sessionUser, UserManager userManager){
    
        
        ProntuarioController prontuarioController = new ProntuarioController();
        prontuarioController.setRepository(new Repository<Prontuario>());
        
        ConsultaController consultaController = new ConsultaController();
        
        PacienteController pacienteController = new PacienteController(prontuarioController);
        pacienteController.setRepository(new Repository<Paciente>());
        
        Paciente paciente = new Paciente();
        paciente.setNome("Luis");
        paciente.setDataNascimento(new Date());
        paciente.setColesterol(10F);
        paciente.setRg("1010101");
        paciente.setTelefone("000000");
        
        pacienteController.save(paciente);
        
        consultaController.setRepository(new Repository<Consulta>());

        PacienteViewController pacienteViewController = 
                new PacienteViewController(pacienteController, sessionUser);
        
        ProntuarioViewController prontuarioViewController = 
                new ProntuarioViewController(prontuarioController, sessionUser);
        
        ConsultaViewController  consultaViewController = 
                new ConsultaViewController(consultaController, sessionUser);
        
        Principal principal = new Principal(consultaViewController,pacienteViewController, prontuarioViewController, userManager);        
        principal.setVisible(true);
    }
}
