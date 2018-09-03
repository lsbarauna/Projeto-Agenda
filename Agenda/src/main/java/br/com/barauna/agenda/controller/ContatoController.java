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
import br.com.barauna.agenda.service.contracts.ContatoService;

/**
 * @author sergio
 *
 */
@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

    @GetMapping("/")
    public Iterable<ContatoPO> getAll() {
        return contatoService.findAll();
    }
    
    @GetMapping("/{contatoId}")
    public ContatoPO getById(@PathVariable Long contatoId) {
    	return contatoService.findById(contatoId).get();
    }
    
    @GetMapping("/nome/{contatoNome}")
    public Iterable<ContatoPO> getByNome(@PathVariable String contatoNome) {
        return contatoService.findByNomeIgnoreCaseContaining(contatoNome);
    }
    
    @GetMapping("/telefone/{contatoTelefone}")
    public ContatoPO getByTelefone(@PathVariable String contatoTelefone) {
        return contatoService.findByTelefone(contatoTelefone);
    }

    @PostMapping("/")
    public ContatoPO create(@Valid @RequestBody ContatoPO contatoRequest) {
        return contatoService.save(contatoRequest);
    }

    @PutMapping("/")
    public ContatoPO update(@Valid @RequestBody ContatoPO contatoRequest) {
    	if(!Optional.ofNullable(contatoRequest.getId()).isPresent()) {
    		throw  new ResourceNotFoundException("Contato sem identificador definido.");
    	}
    	
        return contatoService.save(contatoRequest);
    }

    @DeleteMapping("/{contatoId}")
    public ResponseEntity<?> delete(@PathVariable Long contatoId) {
        return contatoService.findById(contatoId)
                .map(contato -> {
                    contatoService.delete(contato);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado com o identificador " + contatoId));
    }
	
}
