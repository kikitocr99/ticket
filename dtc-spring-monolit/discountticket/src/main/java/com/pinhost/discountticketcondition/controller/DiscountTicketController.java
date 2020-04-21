package com.pinhost.discountticketcondition.controller;

import com.pinhost.discountticketcondition.services.DiscountTicketService;
import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class DiscountTicketController {

    @Autowired
    private DiscountTicketService discountTicketService;

    @GetMapping("/{name}")
    public com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition getDTCByName(@Valid @PathVariable("name") final String name) {
        return discountTicketService.getDTCByName(name);
    }

    @GetMapping("/by/id/{id}")
    public List<com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition> getDtcList(@PathVariable("id") final Integer customerId) {
        return discountTicketService.getDTCList(customerId);
    }
}
