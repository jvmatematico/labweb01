package com.dph.ms.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dph.ms.proyectos.domain.ProyectoInvestigacion;
import com.dph.ms.proyectos.services.ProyectoInvestigacionService;

@RestController
@RequestMapping("/api/v1/proyectos")
public class ProyectoInvestigacionController {
	@Autowired
	private ProyectoInvestigacionService pryInv;
	
	@GetMapping
	public List<ProyectoInvestigacion> listarProyectoInvestigacion(){
		return pryInv.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public ProyectoInvestigacion listarPorId(@PathVariable Long id) {
		return pryInv.buscarPorId(id);
	}
	
	@PostMapping
	public ProyectoInvestigacion crearProyectoInvestigacion(@RequestBody ProyectoInvestigacion proyinves){
		return pryInv.grabar(proyinves);
	}
	
	@PutMapping ("/{id}")
	public ProyectoInvestigacion editarProyectoInvestigacion(@PathVariable Long id, @RequestBody ProyectoInvestigacion proy){
		ProyectoInvestigacion proyDB = pryInv.buscarPorId(id);
		
		proyDB.setEstadoPry(proy.getEstadoPry());
		proyDB.setFechaCierrePry(proy.getFechaCierrePry());
		proyDB.setFechaInicioPry(proy.getFechaInicioPry());
		proyDB.setPresupuestoPry(proy.getPresupuestoPry());
		proyDB.setTitulo(proy.getTitulo());
		proyDB.setResponsable(proy.getResponsable());
		
		return pryInv.grabar(proyDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarProyectoInvestigacion(@PathVariable Long id){
		pryInv.eliminar(id);
	}	

}
