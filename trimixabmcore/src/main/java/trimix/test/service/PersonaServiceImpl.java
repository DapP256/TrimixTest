package trimix.test.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trimix.test.dao.PersonaDao;
import trimix.test.model.Persona;
@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao personaDao;

	@Override
	@Transactional
	public long save(Persona persona) {
	return personaDao.save(persona);
	}

	@Override
	public Persona get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Persona> list() {
		// TODO Auto-generated method stub
		return personaDao.list();
	}

	@Override
	public void update(long id, Persona persona) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Persona> listDocumentos(String tipo) {
		// TODO Auto-generated method stub
		return personaDao.listDocumentos(tipo);
	}



}
