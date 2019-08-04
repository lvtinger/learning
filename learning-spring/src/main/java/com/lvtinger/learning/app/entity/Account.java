package com.lvtinger.learning.app.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"id"})
public class Account implements Serializable {
    private static final long serialVersionUID = -4040817928069648246L;
    private Long id;
    private String username;
    private String password;
}
