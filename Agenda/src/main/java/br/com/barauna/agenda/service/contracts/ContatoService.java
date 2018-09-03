package br.com.barauna.agenda.service.contracts;

import java.util.List;

import br.com.barauna.agenda.po.ContatoPO;
import br.com.barauna.agenda.service.Service;

/**
 * @author sergio
 *
 */
@org.springframework.stereotype.Service
public interface ContatoService extends Service<ContatoPO,Long>{

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.repository.ContatoRepository#findByNomeIgnoreCaseContaining(java.lang.String)
	 */
    List<ContatoPO> findByNomeIgnoreCaseContaining(String nome);

	/* (non-Javadoc)
	 * @see br.com.barauna.agenda.repository.ContatoRepository#findByTelefone(java.lang.String)
	 */
    ContatoPO findByTelefone(String telefone);

}
