package com.rahmah.busana.service.serviceimpl;

import com.rahmah.busana.entity.Clothes;
import com.rahmah.busana.entity.Purchase;
import com.rahmah.busana.entity.PurchaseDetail;
import com.rahmah.busana.entity.User;
import com.rahmah.busana.repository.PurchaseRepository;
import com.rahmah.busana.service.ClothesService;
import com.rahmah.busana.service.PurchaseDetailService;
import com.rahmah.busana.service.PurchaseService;
import com.rahmah.busana.service.UserService;
import com.rahmah.busana.utils.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseDetailService purchaseDetailService;

    @Autowired
    ClothesService clothesService;

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public Purchase transaction(Purchase purchase) {
        Purchase buy = purchaseRepository.save(purchase);
        User user = userService.getUserById(purchase.getUser().getId());
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate now = LocalDate.now();
        buy.setPurchaseDate(dtf.format(now));
        buy.setUser(user);
        Double grandTotal = 0.0;
        for (PurchaseDetail purchaseDetail : purchase.getPurchaseDetails()) {
            purchaseDetail.setPurchase(buy);
            Clothes clothes = clothesService.getClothesById(purchaseDetail.getClothes().getId());

            //check stock
            if(clothes.getStock() == 0) throw new DataNotFoundException("Clothes out of stock");
            else if(clothes.getStock() < purchaseDetail.getQuantity()) throw new DataNotFoundException("you can't buy this clothes with this amount");

            //update stock
            clothes.setStock(clothes.getStock() - purchaseDetail.getQuantity());

            //find grandtotal
            purchaseDetail.setPriceSell((double) (clothes.getPrice() * purchaseDetail.getQuantity()));
            purchaseDetail.setClothes(clothes);
            purchaseDetailService.savePurchaseDetail(purchaseDetail);
            buy.setGrandTotal(grandTotal+=purchaseDetail.getPriceSell());
        }
        return buy;
    }
}
