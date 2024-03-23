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

import com.dph.ms.proyectos.domain.AvanceProyecto;
import com.dph.ms.proyectos.services.AvanceProyectoService;

@RestController
@RequestMapping("/api/v1/avanceProyecto")
public class AvanceProyectoController {
	@Autowired
	private AvanceProyectoService avancePry;
	
	@GetMapping
	public List<AvanceProyecto> listarAvanceProyecto(){
		return avancePry.listarTodos();
	}
	
	@GetMapping ("/{id}")
	public AvanceProyecto listarPorId(@PathVariable Long id){
		return avancePry.buscarPorId(id);
	}
	
	@PostMapping
	public AvanceProyecto crearAvanceProyecto(@RequestBody AvanceProyecto avanproy) {
		return avancePry.grabar(avanproy);
	}
	
	@PutMapping ("/{id}")
	public AvanceProyecto editarAvanceProyecto(@PathVariable Long id, @RequestBody AvanceProyecto ava) {
		AvanceProyecto avaDB = avancePry.buscarPorId(id);
		
		avaDB.setDescripcionAvance(ava.getDescripcionAvance());
		avaDB.setEstadoAv(ava.getEstadoAv());
		avaDB.setFechaREgAvance(ava.getFechaREgAvance());
		avaDB.setPesupuestoGastado(ava.getPesupuestoGastado());
		avaDB.setPresupuestoAsigado(ava.getPresupuestoAsigado());
		
		avaDB.setProyecto(ava.getProyecto());
		
		return avancePry.grabar(avaDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarAvanceProyecto(@PathVariable Long id) {
		avancePry.eliminar(id);
	}

}
