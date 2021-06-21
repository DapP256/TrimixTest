package trimix.test.service;

import java.util.List;

import trimix.test.model.Persona;

public interface PersonaService {
	
	long save(Persona persona);
	Persona get(long id);
	List<Persona>listDocumentos(String tipoDoc);
	List<Persona>list();
	void update(long id, Persona persona);
	void delete (long id);

}
