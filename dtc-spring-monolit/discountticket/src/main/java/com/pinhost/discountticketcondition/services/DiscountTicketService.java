package com.pinhost.discountticketcondition.services;

import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import com.pinhost.mm.dtcdatabase.repositories.DiscountTicketRepositoryH2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountTicketService {

    private DiscountTicketRepositoryH2 discountTicketRepositoryH2;

    public DiscountTicketService(){
        this.discountTicketRepositoryH2 = new DiscountTicketRepositoryH2();
    }

    public DiscountTicketCondition getDTCByName(final String name) {
        return discountTicketRepositoryH2.getDTCByName(name);
    }

    public List<DiscountTicketCondition> getDTCList(final Integer customerId) {
        return discountTicketRepositoryH2.getAllDTCByCustomerId(customerId);
    }
}
