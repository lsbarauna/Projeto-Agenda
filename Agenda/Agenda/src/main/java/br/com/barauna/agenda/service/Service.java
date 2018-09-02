package br.com.barauna.agenda.service;

import java.io.Serializable;
import java.util.Optional;

/**
 * 
 * @author sergio
 *
 * @param <T> Entidade
 * @param <ID> Chave
 */
public interface Service <T, ID extends Serializable> {

	/* (non-Javadoc)
	 * @see org.springframework.data.repository#findAll()
	 */
	public Iterable<T> findAll();	
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository#save(java.lang.Object)
	 */
	public T save(T po);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository#save(java.lang.Iterable)
	 */
	public Iterable<T> save(Iterable<T> pos);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository#delete(java.lang.Object)
	 */
	public void delete(T po);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.repository#findById(java.io.Serializable)
	 */
	public Optional<T> findById(ID id);

}
