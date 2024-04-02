package com.turing.api.order;

import com.turing.api.product.Product;
import com.turing.api.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity(name = "orders")
@Getter
public class Order {
    @Id
    @Column(name = "orders_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

}
