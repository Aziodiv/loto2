package com.bta.loto.model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;


//viking  Loto 6 from 48
public class Bet extends BaseEntity {

    @NonNull

    private Integer number1;

    @NonNull
    @Min(0)
    @Max(48)
    private Integer number2;

    @NonNull
    @Min(0)
    @Max(48)
    private Integer number3;

    @NonNull
    @Min(0)
    @Max(48)
    private Integer number4;

    @NonNull
    @Min(0)
    @Max(48)
    private Integer number5;

    @NonNull
    @Min(0)
    @Max(48)
    private Integer number6;

    private Long userAccountId;

    private LocalDateTime dateTime;

    private Boolean active;




    public Bet(Integer number1,
               Integer number2,
               Integer number3,
               Integer number4,
               Integer number5,
               Integer number6,
               Long userAccountId,
               LocalDateTime dateTime,
               Boolean active) {
        this(null, number1, number2, number3, number4, number5, number6, userAccountId, dateTime, active);
    }


    public Bet(Long id, Integer number1, Integer number2, Integer number3, Integer number4,
               Integer number5, Integer number6, Long userAccountId, LocalDateTime dateTime, Boolean active) {
        super(id);
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        this.userAccountId = userAccountId;
        this.dateTime = dateTime;
        this.active = active;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer getNumber3() {
        return number3;
    }

    public void setNumber3(Integer number3) {
        this.number3 = number3;
    }

    public Integer getNumber4() {
        return number4;
    }

    public void setNumber4(Integer number4) {
        this.number4 = number4;
    }

    public Integer getNumber5() {
        return number5;
    }

    public void setNumber5(Integer number5) {
        this.number5 = number5;
    }

    public Integer getNumber6() {
        return number6;
    }

    public void setNumber6(Integer number6) {
        this.number6 = number6;
    }

    public Long getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(Long userAccountId) {
        this.userAccountId = userAccountId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
