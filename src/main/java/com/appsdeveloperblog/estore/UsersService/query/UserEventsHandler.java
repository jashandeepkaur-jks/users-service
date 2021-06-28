package com.appsdeveloperblog.estore.UsersService.query;

import com.service.core.model.PaymentDetails;
import com.service.core.model.User;
import com.service.core.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
 

@Component
public class UserEventsHandler {

    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
        
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("Pulkit Gupta")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        User user = User.builder()
                .firstName("Jashandeep")
                .lastName("Kaur")
                .userId(query.getUserId())
                .paymentDetails(paymentDetails)
                .build();

        return user;
    }
    
    
}
