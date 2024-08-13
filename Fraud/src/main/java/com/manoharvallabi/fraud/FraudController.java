package com.manoharvallabi.fraud;

import com.manoharvallabi.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId)
    {
       boolean isFradulentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
       return new FraudCheckResponse(isFradulentCustomer);
    }
}
