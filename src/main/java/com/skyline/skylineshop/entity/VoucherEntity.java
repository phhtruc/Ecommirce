package com.skyline.skylineshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Voucher")
public class VoucherEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_voucher;

    @Column(name = "voucherCode", unique = true)
    private String VoucherCode;

    @Column(name = "discountAmount")
    @Positive
    private double discountAmount;

    @Column(name = "[percentage]")
    @Positive
    private int percentage;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "usageLimit")
    private int usageLimit;

    @Column(name = "conditionPrice")
    @Min(value = 0)
    private int conditionPrice;

    @ManyToMany(mappedBy = "vouchers")
    List<UserEntity> userEntityList = new ArrayList<>();

}
