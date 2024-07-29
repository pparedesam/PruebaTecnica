package com.exercise.cuentaservice.movement.domain.entities;

import com.exercise.cuentaservice.account.domain.entities.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movement")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is mandatory")
    @PastOrPresent(message = "Date must be in the past or present")
    private Date date;

    @NotBlank(message = "Type of movement is mandatory")
    private String typeMovement;

    @NotNull(message = "Value is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than zero")
    private BigDecimal value;

    @NotNull(message = "Balance is mandatory")
    private BigDecimal balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_account")
    private Account account;
}
