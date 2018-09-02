package br.com.barauna.agenda.service.contracts;

import java.util.List;

import br.com.barauna.agenda.po.ContatoPO;
import br.com.barauna.agenda.service.Service;

/**
 * @author sergio
 *
 */
@org.springframework.stereotype.Service
public interface MessageService extends Service<ContatoPO,Long>{

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.repository.MessageRepository#findByNomeIgnoreCaseContaining(java.lang.String)
	 */
    List<ContatoPO> findByNomeIgnoreCaseContaining(String nome);

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.repository.MessageRepository#findByTelefone(java.lang.String)
	 */
    ContatoPO findByTelefone(String telefone);

}
