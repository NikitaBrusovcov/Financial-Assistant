package bsu.tp.financial.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Operation {
    private int id;
    private String description;
    private LocalDateTime dateTime;
    private BigDecimal money;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return description + " ||| " + dateTime + " ||| " + money + " ||| " + type;
    }
}
