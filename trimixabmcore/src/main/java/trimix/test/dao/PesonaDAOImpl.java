package trimix.test.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trimix.test.model.Persona;
@Repository
public class PesonaDAOImpl implements PersonaDao{
	@Autowired
	private SessionFactory sessionFactory;
	private javax.persistence.Query query;

	@Override
	public long save(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);
		return persona.getPerId();
	}

	@Override
	public Persona get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> list() {
		// TODO Auto-generated method stub
		List<Persona> listaPersonas = sessionFactory.getCurrentSession().createQuery("from Persona").list();
		return listaPersonas;
		
	}

	@Override
	public List<Persona> listDocumentos(String tipoDoc) {
		List<Persona> listaPersonas = sessionFactory.getCurrentSession().createQuery("from Persona where perNombre = :tipoDoc").list();
		return listaPersonas;
	}

	@Override
	public void update(long id, Persona persona) {
		// TODO Auto-generated method stubS
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	
	

	
}
