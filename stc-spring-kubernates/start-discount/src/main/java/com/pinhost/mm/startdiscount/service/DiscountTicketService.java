package com.pinhost.mm.startdiscount.service;

import com.pinhost.mm.startdiscount.model.DiscountTicketCondition;
import com.pinhost.mm.startdiscount.repository.DiscountTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountTicketService {
    @Autowired
    private DiscountTicketRepository discountTicketConditionRepository;

    public DiscountTicketCondition getDTCByName(final String name) {
        return discountTicketConditionRepository.getDTCByName(name);
    }

    public List<DiscountTicketCondition> getDTCList(final Integer customerId) {
        return discountTicketConditionRepository.getAllDTCByCustomerId(customerId);
    }
}
