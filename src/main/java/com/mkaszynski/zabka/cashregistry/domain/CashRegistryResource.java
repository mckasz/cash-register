package com.mkaszynski.zabka.cashregistry.domain;

import com.mkaszynski.zabka.cashregistry.dto.CashRegistryDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
class CashRegistryResource {
    private final CashRegistryService cashRegistryService;

    public CashRegistryResource(CashRegistryService cashRegistryService) {
        this.cashRegistryService = cashRegistryService;
    }

    @GetMapping(value = "/cash-register/{id}",
        produces = "application/json")
    public @ResponseBody
    CashRegistryDto getState(@PathVariable int id) {
        return cashRegistryService.get(id);
    }

    @PutMapping(value = "/cash-register/{id}/{name}",
        produces = "application/json")
    public @ResponseBody
    CashRegistryDto scanProduct(@PathVariable int id, @PathVariable String name) {
        return cashRegistryService.scanProduct(id, name);
    }

    @PostMapping(value = "/cash-register/{id}",
        produces = "application/json")
    public @ResponseBody
    CashRegistryDto checkout(@PathVariable int id) {
        return cashRegistryService.checkout(id);
    }
}
