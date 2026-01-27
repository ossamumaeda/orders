package com.delivery.api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delivery.api.domain.payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    
}
