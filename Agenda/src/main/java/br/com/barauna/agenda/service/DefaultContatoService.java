package br.com.barauna.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.barauna.agenda.exception.ApplicationException;
import br.com.barauna.agenda.po.ContatoPO;
import br.com.barauna.agenda.repository.ContatoRepository;
import br.com.barauna.agenda.service.contracts.ContatoService;

/**
 * @author sergio
 *
 */
@Component
public class DefaultContatoService extends AbstractService<ContatoPO, Long> implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public CrudRepository<ContatoPO, Long> getCrudRepository() {
		return contatoRepository;
	}

	/**
	 * Persiste o contato.
	 * 
	 * @param contatoPO Contato a ser persistido
	 * @return Contato persistido
	 * @throws Levanta uma exceção de aplicação caso já exista um contato o mesmo número de telefone.
	 */
	@Override
	public ContatoPO save(ContatoPO contatoPO) {

		Optional<ContatoPO> contatoByTefone = contatoRepository.findByTelefone(contatoPO.getTelefone());
		
		if (contatoByTefone.isPresent() && !contatoByTefone.get().getId().equals(contatoPO.getId())) {
			throw new ApplicationException("Já existe um contato com esse telefone.");
		}
		
		return super.save(contatoPO);

	}

	
	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.contracts.ContatoService#findByNomeIgnoreCaseContaining(java.lang.String)
	 */
	@Override
	public List<ContatoPO> findByNomeIgnoreCaseContaining(String nome) {
		return contatoRepository.findByNomeIgnoreCaseContaining(nome);
	}

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.contracts.ContatoService#findByTelefone(java.lang.String)
	 */
	@Override
	public ContatoPO findByTelefone(String telefone) {
		return contatoRepository.findByTelefone(telefone).orElse(new  ContatoPO());
	}
	
	

}
