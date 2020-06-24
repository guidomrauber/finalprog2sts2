package com.example.main.service;

import com.example.main.entity.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.repository.MutanteRepository;

@Service
@Transactional
public class MutanteService {

	@Autowired
	MutanteRepository mutanterepository;
	public List<Mutante> obtenerTodos(){
        List<Mutante> lista = mutanterepository.findAll();
        return lista;
    }

    public Optional<Mutante> obtenerPorId(Long id){
        return mutanterepository.findById(id);
    }
    
    public void guardar(Mutante mutante){
        mutanterepository.save(mutante);
    }
        public void borrar(Long id){
        mutanterepository.deleteById(id);
    }

   
    public boolean existePorId(Long strings){
        return mutanterepository.existsById(strings);
    }
}
