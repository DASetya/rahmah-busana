package com.rahmah.busana.controller;

import com.rahmah.busana.entity.Purchase;
import com.rahmah.busana.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    Purchase transaction(@RequestBody Purchase purchase){
        return purchaseService.transaction(purchase);
    }
}
