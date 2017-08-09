package com.example.bravo.dao;

import com.example.bravo.po.Attr;
import com.example.bravo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttrRepository extends JpaRepository<Attr,Long> {

}
