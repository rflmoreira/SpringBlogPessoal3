package org.generation.blogpessoal.repository;

// "findAll"(BUSCA TODOS PELO TÍTULO) <- VAI BUSCAR PELO TÍTULO ABAIXO
// "Titulo"(É O NOME DA VARIAVEL DE POSTAGENS)
// "Containing"(É IGUAL AO "LIKE" DO SQL) <- BUSCA TUDO QUE ESTÁ DENTRO DO TÍTULO
// "IgnoreCase" (PADRONIZA TODOS OS CARACTERES PARA MINÚSCULO)


import java.util.List;

import org.generation.blogpessoal.model.Postagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long> {

	public List<Postagens> findAllByTituloContainingIgnoreCase (String titulo);
}
