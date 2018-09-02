package br.com.barauna.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import br.com.barauna.agenda.exception.ApplicationException;
import br.com.barauna.agenda.po.ContatoPO;
import br.com.barauna.agenda.repository.MessageRepository;
import br.com.barauna.agenda.service.contracts.MessageService;

/**
 * @author sergio
 *
 */
@Component
public class DefaultMessageService extends AbstractService<ContatoPO, Long> implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public CrudRepository<ContatoPO, Long> getCrudRepository() {
		return messageRepository;
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

		Optional<ContatoPO> contatoByTefone = messageRepository.findByTelefone(contatoPO.getTelefone());
		
		if (contatoByTefone.isPresent() && !contatoByTefone.get().getId().equals(contatoPO.getId())) {
			throw new ApplicationException("Já existe um contato com esse telefone.");
		}
		
		return super.save(contatoPO);

	}

	
	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.contracts.MessageService#findByNomeIgnoreCaseContaining(java.lang.String)
	 */
	@Override
	public List<ContatoPO> findByNomeIgnoreCaseContaining(String nome) {
		return messageRepository.findByNomeIgnoreCaseContaining(nome);
	}

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.service.contracts.MessageService#findByTelefone(java.lang.String)
	 */
	@Override
	public ContatoPO findByTelefone(String telefone) {
		return messageRepository.findByTelefone(telefone).orElse(new  ContatoPO());
	}
	
	

}
