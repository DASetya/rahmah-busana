package com.rahmah.busana.repository;

import com.rahmah.busana.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, Long> {

    @Query(value = "SELECT * FROM pakaian p WHERE p.brand = ?1", nativeQuery = true)
    List<Clothes> findByBrand(String brand);
}
