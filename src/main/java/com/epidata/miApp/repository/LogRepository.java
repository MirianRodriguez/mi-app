package com.epidata.miApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epidata.miApp.entity.Log;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Long>{
    
}
