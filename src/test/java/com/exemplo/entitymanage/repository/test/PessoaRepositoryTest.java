package com.exemplo.entitymanage.repository.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.exemplo.entitymanage.ComExemploEntityManageApplicationTests;
import com.exemplo.entitymanage.model.Pessoa;
import com.exemplo.entitymanage.repository.PessoaRepository;

public class PessoaRepositoryTest extends ComExemploEntityManageApplicationTests {

	@Autowired
	PessoaRepository pessoaRepository;

	@Test
	public void findByNameTest() {

		Pessoa pessoa = new Pessoa("Lucas", "lucas@gmail.com");

		pessoaRepository.persist(pessoa);

		List<Pessoa> pessoas = pessoaRepository.find("Lucas", null);

		assertEquals(1, pessoas.size());
		assertEquals("Lucas", pessoas.get(0).getNome());
	}

	@Test
	public void findByEmailTest() {

		Pessoa pessoa = new Pessoa("Jose", "jose@gmail.com");

		pessoaRepository.persist(pessoa);

		List<Pessoa> pessoas = pessoaRepository.find(null, "jose@gmail.com");

		assertEquals(1, pessoas.size());
		assertEquals("jose@gmail.com", pessoas.get(0).getEmail());

	}

	@Test
	public void findByNameAndEmailTest() {

		Pessoa pessoa = new Pessoa("Maria", "maria@gmail.com");

		pessoaRepository.persist(pessoa);

		List<Pessoa> pessoas = pessoaRepository.find("Maria", "maria@gmail.com");

		assertEquals(1, pessoas.size());
		assertEquals("Maria", pessoas.get(0).getNome());
		assertEquals("maria@gmail.com", pessoas.get(0).getEmail());

	}

}
