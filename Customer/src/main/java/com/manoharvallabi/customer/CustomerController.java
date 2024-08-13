package com.manoharvallabi.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        log.info("Registering Customer:",customerRequest);
        customerService.register(customerRequest);
    }

}
