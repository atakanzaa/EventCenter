package com.example.EventCenter.Service;

import com.example.EventCenter.Entity.Discount;
import com.example.EventCenter.Repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Discount getDiscountById(Long id) {
        return discountRepository.findById(id).orElse(null);
    }

    public Discount createDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public Discount updateDiscount(Long id, Discount discountDetails) {
        Discount discount = discountRepository.findById(id).orElse(null);
        if (discount != null) {
            discount.setDiscountPercentage(discountDetails.getDiscountPercentage());
            discount.setStartDate(discountDetails.getStartDate());
            discount.setEndDate(discountDetails.getEndDate());
            return discountRepository.save(discount);
        }
        return null;
    }

    public void deleteDiscount(Long id) {
        discountRepository.deleteById(id);
    }
}

