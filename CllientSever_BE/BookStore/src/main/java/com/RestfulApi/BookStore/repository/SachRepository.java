package com.RestfulApi.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.RestfulApi.BookStore.entity.Sach;

public interface SachRepository extends JpaRepository<Sach, Integer>, JpaSpecificationExecutor<Sach>{

}
