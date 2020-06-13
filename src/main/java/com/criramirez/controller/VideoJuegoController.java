package com.criramirez.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.criramirez.collections.VideoJuego;
import com.criramirez.repository.VideoJuegoRepository;

@RestController
@RequestMapping("/videojuego")
public class VideoJuegoController {
	
	@Autowired
	private VideoJuegoRepository repository;
	
	@PostMapping("/add")
	public String agregarVideojuego(@RequestBody VideoJuego videoJuego) {
		videoJuego.set_id(ObjectId.get().toString());
		repository.save(videoJuego);
		return "Se agrego videojuego con id: "+videoJuego.get_id();
	};
	
	@PostMapping("/update")
	public String actualizarVideojuego(@RequestBody VideoJuego videoJuego) {
		//videoJuego.set_id(ObjectId.get().toString());
		repository.save(videoJuego);
		return "Se actualizo videojuego con id: "+videoJuego.get_id();
	};
	
	@GetMapping("/getAll")
	public List<VideoJuego> obtenerVideojuegos(){	
		return repository.findAll();		
	}
	
	@GetMapping("/getAll/{id}")
	public Optional<VideoJuego> obteneJuego(@PathVariable String id) {
		
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String borrarVideojuego(@PathVariable String id) {
		repository.deleteById(id);
		return "Se ha eliminado el videojuego con id: "+id; 
	}

}
