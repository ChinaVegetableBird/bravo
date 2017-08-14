package com.example.bravo.dao;

import com.example.bravo.po.Res;
import com.example.bravo.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepository extends JpaRepository<Res,Long> {

}
