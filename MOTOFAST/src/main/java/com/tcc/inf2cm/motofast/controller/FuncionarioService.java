package com.tcc.inf2cm.motofast.controller;



import org.springframework.stereotype.Service;

import com.tcc.inf2cm.motofast.model.Funcionario;
import com.tcc.inf2cm.motofast.repository.FuncionarioRepository;


@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public Funcionario obterFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public void atualizarPerfilFuncionario(Long id, Funcionario funcionario) {
      Funcionario funcionarioDb = this.obterFuncionarioPorId(id);
      
      
      System.out.println(funcionarioDb.getId() +  " ID");
      funcionarioRepository.save(funcionarioDb);
      
    }

    public void excluirPerfilFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}