package com.klinger.JavaProjectOne.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klinger.JavaProjectOne.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
