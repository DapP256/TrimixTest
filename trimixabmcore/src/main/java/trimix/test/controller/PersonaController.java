package trimix.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trimix.test.model.Persona;
import trimix.test.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	@GetMapping("/api/personas")
	public ResponseEntity<List<Persona>> getPersonas(){
		
		List<Persona> listaPersonas = personaService.list();
		return ResponseEntity.ok().body(listaPersonas);
		
	}
	
	@PostMapping("/api/agregar")
	public ResponseEntity<?> save(@RequestBody Persona persona) {
		long id = personaService.save(persona);
		return ResponseEntity.ok().body("Se ha agregado" +persona.getPerNombre()+" a la Lista ");
	}
	
	@GetMapping("/api/personas/{tipo}")
	public ResponseEntity<List<Persona>> getPersonass(@PathVariable("tipo") String tipo){
		
		List<Persona> listaPersonas = personaService.listDocumentos(tipo);
		return ResponseEntity.ok().body(listaPersonas);
		
	}
	
	

}
