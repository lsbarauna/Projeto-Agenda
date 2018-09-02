package br.com.barauna.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.barauna.agenda.po.ContatoPO;

/**
 * @author sergio
 *
 */
public interface MessageRepository extends CrudRepository<ContatoPO, Long> {

	/**
	 * Retorna todos os contatos que contenha no nome a String passada como parâmetro
	 * 	 
	 * @param nome 
	 * @return Lista de Contatos
	 */
    public List<ContatoPO> findByNomeIgnoreCaseContaining(String nome);

    /**
	 * Retorna o contato que a partir do número do telefone
	 * 	 
	 * @param telefone 
	 * @return Contato associado ao telefone
	 */
    public Optional<ContatoPO> findByTelefone(String telefone);

}
