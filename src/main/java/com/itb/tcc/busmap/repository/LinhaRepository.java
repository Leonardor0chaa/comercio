package com.itb.tcc.busmap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itb.tcc.busmap.model.Linha;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {

}
