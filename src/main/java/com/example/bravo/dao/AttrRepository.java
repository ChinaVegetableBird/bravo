package com.example.bravo.dao;

import com.example.bravo.po.Attr;
import com.example.bravo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttrRepository extends JpaRepository<Attr,Long> {
    List<Attr> findByUid(Long uid);
}
