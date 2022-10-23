package com.rahmah.busana.controller;

import com.rahmah.busana.entity.Clothes;
import com.rahmah.busana.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClothesController {

    @Autowired
    ClothesService clothesService;

    @PostMapping
    public Clothes addBook(@RequestBody Clothes clothes){
        return clothesService.addClothes(clothes);
    }

    @GetMapping("/{id}")
    public Clothes getClothesById(@PathVariable Long id){
        return clothesService.getClothesById(id);
    }

    @GetMapping
    public List<Clothes> getAllClothes(){
        return clothesService.getAllClothes();
    }

    @PutMapping
    public Clothes updateClothes(@RequestBody Clothes clothes){
        return clothesService.updateClothes(clothes);
    }

    @DeleteMapping("/{id}")
    public void deleteClothes(@PathVariable Long id){
        clothesService.deleteClothes(id);
    }

    @GetMapping("/brand")
    public List<Clothes> getClothesByBrand(@RequestParam String brand){
        return clothesService.getClothesByBrand(brand);
    }
}
