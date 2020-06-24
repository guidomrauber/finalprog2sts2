package com.example.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import com.example.main.DTO.Mensaje;
import com.example.main.entity.Mutante;
import com.example.main.service.MutanteService;



@RestController
@RequestMapping("/api/v1/mutante")
@CrossOrigin(origins = "http://localhost:4200")
public class MutanteController {

	@Autowired
    MutanteService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Mutante>> getLista(){
        List<Mutante> lista = productoService.obtenerTodos();
        return new ResponseEntity<List<Mutante>>(lista, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Mutante> getOne(@PathVariable Long id){
        if(!productoService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
        Mutante producto = productoService.obtenerPorId(id).get();
        return new ResponseEntity<Mutante>(producto, HttpStatus.OK);
    }
@Autowired
	private MutanteService mutanteService;

    @PostMapping("/nuevo")
    
    public ResponseEntity create(@RequestBody Mutante producto){
    	try {
    		System.out.println(producto.getDna2());
    		System.out.println(producto.getCondicion());
    		productoService.guardar(producto);
return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Producto guardado.\"}");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body
		("{\"message\": \"Error. intente nuevamenter.\"}");
						
		}

    		
        
        
    }

    

	
}
