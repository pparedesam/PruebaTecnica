package com.exercise.cuentaservice.account.domain.entities;

import com.exercise.cuentaservice.movement.domain.entities.Movement;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Account type is mandatory")
    private String type;

    @NotNull(message = "Balance is mandatory")
    @DecimalMin(value = "0.0", message = "Balance must be positive")
    private BigDecimal balance;

    @NotBlank(message = "Account number is mandatory")
    @Size(min = 1, max = 20, message = "Account number must be between 10 and 20 characters")
    private String number;

    @NotNull(message = "State is mandatory")
    private Boolean state;

    @NotNull(message = "Client ID is mandatory")
    private Long idClient;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private List<Movement> movementList;

}
