package com.mkaszynski.zabka.domain;

import com.mkaszynski.zabka.dto.CashRegistryDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class CashRegistryResource {
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
