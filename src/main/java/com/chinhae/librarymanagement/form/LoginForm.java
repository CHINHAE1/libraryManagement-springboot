package com.chinhae.librarymanagement.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/9 02:37
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String userName;
    private String password;
    private Integer roleID;
}
