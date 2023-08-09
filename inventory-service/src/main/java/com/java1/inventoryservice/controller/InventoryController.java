package com.java1.inventoryservice.controller;


import com.java1.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;


    // http://loclhost:6062/api/inventory?sku-code=iphone-13&sku-code=iphone13-red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam List<String> skuCode) {

        return inventoryService.isInStock(skuCode);
    }
}

