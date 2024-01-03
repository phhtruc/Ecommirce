package com.skyline.skylineshop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "[User]")
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "phone", unique = true)
    @Pattern(regexp = "^0[0-9]{9}$")
    private String phone;

    @Column(name = "[password]")
    private String password;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status")
    private Integer status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_user"),
                                    inverseJoinColumns = @JoinColumn(name = "id_role"))
    List<RoleEntity> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_voucher", joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_voucher"))
    List<VoucherEntity> vouchers = new ArrayList<>();

}
