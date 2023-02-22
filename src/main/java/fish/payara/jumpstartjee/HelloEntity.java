package fish.payara.jumpstartjee;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbNumberFormat;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.config.PropertyOrderStrategy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
@Getter
@Setter
public class HelloEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private String name;
    private String greeting;
    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate entityDate;
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime greetingDate;
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
    @JsonbNumberFormat("#0,000.00")
    private BigDecimal helloPrize;

    @PrePersist
    private void init() {
        dateCreated = LocalDateTime.now(ZoneOffset.UTC);
    }
}
