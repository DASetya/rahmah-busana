package com.rahmah.busana.service;

import com.rahmah.busana.entity.Clothes;

import java.util.List;

public interface ClothesService {
    public Clothes addClothes(Clothes clothes);
    public Clothes getClothesById(Long id);
    public List<Clothes> getAllClothes();
    public Clothes updateClothes(Clothes clothes);
    public void deleteClothes(Long id);
    public List<Clothes> getClothesByBrand(String brand);
}
