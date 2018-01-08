package com.exemplo.entitymanage.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.exemplo.entitymanage.model.Pessoa;

@Repository
public class PessoaRepository {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(Pessoa pessoa) {

		em.persist(pessoa);
	}

	public List<Pessoa> find(String nome, String email) {

		StringBuilder query = new StringBuilder();

		query.append("Select p from Pessoa p where 1 = 1 ");

		if (!StringUtils.isEmpty(nome)) {

			query.append("and nome = '" + nome + "'");
		}
		if (!StringUtils.isEmpty(email)) {

			query.append("and email = '" + email + "'");
		}

		return em.createQuery(query.toString()).getResultList();
	}
}
