package com.adobe.bookstore.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAOrderRepository extends JpaRepository<OrderJpa, OrderId> {
}
