package com.datpham.foodorder.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    private int status=200;
    private int id;
    private boolean isSuccess = false;
    private String desc;
    private Object data;
}
