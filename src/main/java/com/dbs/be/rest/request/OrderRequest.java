package com.dbs.be.rest.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest extends BaseRequest{
    private String orderCode;
    private List<String> courseId;
    private String payMethod;
    private String studentId;
}
