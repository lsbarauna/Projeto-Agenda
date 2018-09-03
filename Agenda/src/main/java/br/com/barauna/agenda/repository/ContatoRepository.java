package br.com.barauna.agenda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.barauna.agenda.po.ContatoPO;

/**
 * @author sergio
 *
 */
public interface ContatoRepository extends CrudRepository<ContatoPO, Long> {

	/**
	 * Retorna todos os contatos que contenha no nome o texto passado como parâmetro
	 * 	 
	 * @param nome 
	 * @return Lista de Contatos
	 */
    public List<ContatoPO> findByNomeIgnoreCaseContaining(String nome);

    /**
	 * Retorna o contato associado ao telefone passado como parâmetro
	 * 	 
	 * @param telefone 
	 * @return Contato 
	 */
    public Optional<ContatoPO> findByTelefone(String telefone);

}
