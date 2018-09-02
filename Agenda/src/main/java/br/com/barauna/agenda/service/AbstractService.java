package br.com.barauna.agenda.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.barauna.agenda.po.AbstractPO;


/**
 * @author sergio
 *
 * @param <T>
 * @param <ID>
 */
@Transactional
public abstract class AbstractService<T extends AbstractPO, ID extends Serializable> implements Service<T, ID> {

	public abstract CrudRepository<T, ID> getCrudRepository();
	
	
	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.Service#findAll()
	 */
	public Iterable<T> findAll() {
		return  getCrudRepository().findAll();
	}

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.Service#delete(java.lang.Object)
	 */
	public void delete(T po) {
		getCrudRepository().delete(po);
	}

	/**
	 * @param id
	 */
	public void delete(ID id) {
		getCrudRepository().deleteById(id);
	}

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.Service#findById(java.io.Serializable)
	 */
	public Optional<T> findById(ID id) {
		return getCrudRepository().findById(id);
	}

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.Service#save(java.lang.Object)
	 */
	public T save(T po) {
		return getCrudRepository().save(po);
	}
	
	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.Service#save(java.lang.Iterable)
	 */
	public Iterable<T> save(Iterable<T> pos) {
		return getCrudRepository().saveAll(pos);
	}

}
