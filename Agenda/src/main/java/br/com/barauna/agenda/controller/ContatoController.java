package br.com.barauna.agenda.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barauna.agenda.exception.ResourceNotFoundException;
import br.com.barauna.agenda.po.ContatoPO;
import br.com.barauna.agenda.service.contracts.MessageService;

/**
 * @author sergio
 *
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private MessageService messageService;


    @GetMapping("/")
    public Iterable<ContatoPO> getContatos() {
        return messageService.findAll();
    }
    
    @GetMapping("/{contatoId}")
    public ContatoPO getContato(@PathVariable Long contatoId) {
    	return messageService.findById(contatoId).get();
    }
    
    @GetMapping("/nome/{contatoNome}")
    public Iterable<ContatoPO> getByNomePO(@PathVariable String contatoNome) {
        return messageService.findByNomeIgnoreCaseContaining(contatoNome);
    }
    
    @GetMapping("/telefone/{contatoTelefone}")
    public ContatoPO getByTelefone(@PathVariable String contatoTelefone) {
        return messageService.findByTelefone(contatoTelefone);
    }

    @PostMapping("/")
    public ContatoPO create(@Valid @RequestBody ContatoPO contatoRequest) {
        return messageService.save(contatoRequest);
    }

    @PutMapping("/")
    public ContatoPO update(@Valid @RequestBody ContatoPO contatoRequest) {
    	if(!Optional.ofNullable(contatoRequest.getId()).isPresent()) {
    		throw  new ResourceNotFoundException("Contato sem identificador definido.");
    	}
    	
        return messageService.save(contatoRequest);
    }


    @DeleteMapping("/{contatoId}")
    public ResponseEntity<?> delete(@PathVariable Long contatoId) {
        return messageService.findById(contatoId)
                .map(contato -> {
                    messageService.delete(contato);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado com o identificador " + contatoId));
    }
	
}