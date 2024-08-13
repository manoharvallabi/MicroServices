package com.manoharvallabi.customer;

import com.manoharvallabi.clients.fraud.FraudCheckResponse;
import com.manoharvallabi.clients.fraud.FraudClient;
import com.manoharvallabi.clients.notifications.NotificationClient;
import com.manoharvallabi.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void register(CustomerRequest customerRequest) {

        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email()).build();
        customerRepository.saveAndFlush(customer);

    FraudCheckResponse fraudCheckResponse= fraudClient.isFraudster(customer.getId());

    if(fraudCheckResponse.isFraudster())
    {
        throw new IllegalStateException("fraudster");
    }

        NotificationRequest notificationRequest = NotificationRequest.builder()
                        .id(customer.getId())
                        .message("Hi "+customer.getFirstName()+" welcome")
                        .email(customer.getEmail())
                        .build();

    notificationClient.sendNotification(notificationRequest);

    }

}
