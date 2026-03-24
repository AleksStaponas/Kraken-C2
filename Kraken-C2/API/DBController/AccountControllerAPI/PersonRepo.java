package com.example.Kraken_C2.API.DBController.AccountControllerAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepo extends JpaRepository<Person,Long> {

    @Query(value = "SELECT MAX(mark) FROM table_1", nativeQuery = true)
    public Long getMax();

    @Query(value = "SELECT MIN(mark) FROM table_1", nativeQuery = true)
    public Long getMin();

    @Query("SELECT COUNT(p) FROM Person p WHERE p.name = :name")
    public long countByUsername(@Param("name") String name);



}

