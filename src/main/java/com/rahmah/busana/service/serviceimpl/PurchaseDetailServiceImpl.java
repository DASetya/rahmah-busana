package com.rahmah.busana.service.serviceimpl;

import com.rahmah.busana.entity.PurchaseDetail;
import com.rahmah.busana.repository.PurchaseDetailRepository;
import com.rahmah.busana.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {

    @Autowired
    PurchaseDetailRepository purchaseDetailRepository;

    @Override
    public PurchaseDetail savePurchaseDetail(PurchaseDetail purchaseDetail) {
        return purchaseDetailRepository.save(purchaseDetail);
    }
}
