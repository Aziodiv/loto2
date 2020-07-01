package com.bta.loto.model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

public class PlayResult extends BaseEntity{

    private Integer number1;

    private Integer number2;

    private Integer number3;

    private Integer number4;

    private Integer number5;

    private Integer number6;

    private LocalDateTime dateTime;

    public PlayResult() {
    }

    public PlayResult(Integer number1, Integer number2, Integer number3, Integer number4,
                      Integer number5, Integer number6, LocalDateTime dateTime) {
        this(null,number1,number2,number3,number4,number5,number6,dateTime);
    }

    public PlayResult(Long id, Integer number1, Integer number2, Integer number3, Integer number4,
                      Integer number5, Integer number6, LocalDateTime dateTime) {
        super(id);
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.number6 = number6;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
