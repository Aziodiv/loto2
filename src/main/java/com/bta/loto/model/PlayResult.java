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

}
