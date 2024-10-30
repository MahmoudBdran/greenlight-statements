package com.mbsystems.greenlight_statements.service;

import com.mbsystems.greenlight_statements.models.Invoice;
import com.mbsystems.greenlight_statements.models.Item;
import com.mbsystems.greenlight_statements.models.Owner;
import com.mbsystems.greenlight_statements.repository.InvoiceRepository;
import com.mbsystems.greenlight_statements.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item saveItem(Item item) {
        if(checkInvoiceInDB(item.getInvoice().getId())){


            itemRepository.save(item);
            BigDecimal totalCostOfItem = item.getItemPrice()
                                            .multiply(item.getItemQuantity())
                                            .multiply (item.getPercentage().divide(BigDecimal.valueOf(100)));

            Invoice invoice =invoiceRepository.findById(item.getInvoice().getId()).orElseThrow();
            invoice.setAmount(invoice.getAmount().add(totalCostOfItem));
            invoiceRepository.save(invoice);

            return item;
        }
        return null;
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public boolean checkInvoiceInDB(Long id){
        return invoiceRepository.findById(id).isPresent();
    }
    public List<Item> getItemByInvoiceId(Long invoiceId) {
        return itemRepository.findByInvoiceId(invoiceId);
    }

}

