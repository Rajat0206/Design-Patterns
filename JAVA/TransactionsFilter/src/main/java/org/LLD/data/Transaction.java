package org.LLD.data;

import java.time.LocalDateTime;

public class Transaction {
    Long id;
    Long user_id;
    LocalDateTime time;
    Double amount;

    public Transaction(Long id, Long user_id, LocalDateTime time, Double amount) {
        this.id = id;
        this.user_id = user_id;
        this.time = time;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", time=" + time +
                ", amount=" + amount +
                '}';
    }
}
