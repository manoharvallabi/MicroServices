package com.manoharvallabi.fraud;

import com.manoharvallabi.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId)
    {
        log.info("checking customerId {}",customerId);
       boolean isFradulentCustomer = fraudCheckService.isFraudlentCustomer(customerId);
       log.info("isFraudster returns {}",isFradulentCustomer);
       return new FraudCheckResponse(isFradulentCustomer);
    }
}
