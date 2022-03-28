package com.RestfulApi.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.RestfulApi.BookStore.entity.Nhasanxuat;

public interface NhaxuatbanRepository extends JpaRepository<Nhasanxuat, Integer>, JpaSpecificationExecutor<Nhasanxuat>{

}
