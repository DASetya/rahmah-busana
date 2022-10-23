package com.rahmah.busana.service.serviceimpl;

import com.rahmah.busana.entity.Clothes;
import com.rahmah.busana.repository.ClothesRepository;
import com.rahmah.busana.service.ClothesService;
import com.rahmah.busana.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    ClothesRepository clothesRepository;

    @Override
    public Clothes addClothes(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    @Override
    public Clothes getClothesById(Long id) {
        verify(id);
        return clothesRepository.findById(id).get();
    }

    @Override
    public List<Clothes> getAllClothes() {
        return clothesRepository.findAll();
    }

    @Override
    public Clothes updateClothes(Clothes clothes) {
        verify(clothes.getId());
        return clothesRepository.save(clothes);
    }

    @Override
    public void deleteClothes(Long id) {
        verify(id);
        clothesRepository.deleteById(id);
    }

    @Override
    public List<Clothes> getClothesByBrand(String brand) {
        return clothesRepository.findByBrand(brand);
    }

    private void verify(Long id) {
        if(!clothesRepository.findById(id).isPresent()){
            String message = String.format("Resource %s with ID %s not found", "clothes", id);
            throw new DataNotFoundException(message);
        }
    }
}
