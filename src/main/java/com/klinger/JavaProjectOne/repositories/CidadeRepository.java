package com.klinger.JavaProjectOne.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klinger.JavaProjectOne.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
