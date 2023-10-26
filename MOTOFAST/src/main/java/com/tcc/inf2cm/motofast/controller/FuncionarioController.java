package com.tcc.inf2cm.motofast.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tcc.inf2cm.motofast.model.Funcionario;
import com.tcc.inf2cm.motofast.repository.FuncionarioRepository;

@Controller
@RequestMapping("/motofast/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/novo-funcionario")
    public String novoFuncionario(Funcionario funcionario, Model model) { 
        model.addAttribute("funcionario", funcionario);

        return "CadastroFuncionario";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFuncionario(@ModelAttribute Funcionario funcionario) {
        // Defina o status como "ATIVO" antes de salvar o cliente
        funcionario.setStatus(true);
        
        // Salve o cliente no banco de dados
        funcionarioRepository.save(funcionario);

        // Redirecione para a página do perfil do cliente recém-cadastrado
        return "redirect:/motofast/funcionario/perfil-funcionario/" + funcionario.getId();
    }


    @GetMapping("/perfil-funcionario/{id}")
    public String exibirPerfilFuncionario(@PathVariable Long id, Model model) {
        Funcionario funcionario = funcionarioService.obterFuncionarioPorId(id);
        model.addAttribute("funcionario", funcionario);
        return "Agenda";
    }

    @PostMapping("/atualizar-perfil/{id}")
    public String atualizarPerfilFuncionario(@PathVariable Long id, @ModelAttribute Funcionario funcionario) {
    	//funcionarioService.atualizarPerfilFuncionario(id, funcionario);
    	
    	 funcionarioRepository.save(funcionario);
  
        return "redirect:/motofast/funcionario/perfil-funcionario/" + id;
    }
        
    @PostMapping("/excluir-funcionario/{id}")
    public String atualizaStatus(@PathVariable Long id) {
    	Funcionario funcionario = funcionarioRepository.getById(id);
    	
    	funcionario.setStatus(false);
    	
    	funcionarioRepository.save(funcionario);
    	System.out.println(funcionario);
    	return "redirect:/motofast/funcionario/perfil-funcionario/" + id;
    }
}




