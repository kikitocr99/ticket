package com.pinhost.mm.userservice.model;

import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;

import java.util.ArrayList;
import java.util.List;

public class DiscountList {
    private List<DiscountTicketCondition> discountTicketCondictions;

    public DiscountList(){
        discountTicketCondictions = new ArrayList<>();
    }

    public DiscountList(List<DiscountTicketCondition> discountTicketCondictions) {
        this.discountTicketCondictions = discountTicketCondictions;
    }

    public List<DiscountTicketCondition> getDiscountTicketCondictions() {
        return discountTicketCondictions;
    }

    public void setDiscountTicketCondictions(List<DiscountTicketCondition> discountTicketCondictions) {
        this.discountTicketCondictions = discountTicketCondictions;
    }
}
