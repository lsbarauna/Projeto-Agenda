package br.com.barauna.agenda.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato")
public class ContatoPO extends AbstractPO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "contato_generator")
    @SequenceGenerator(
            name = "contato_generator",
            sequenceName = "contato_sequence",
            allocationSize=1
    )
    private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min = 8, max = 20)
	private String telefone;
	
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
