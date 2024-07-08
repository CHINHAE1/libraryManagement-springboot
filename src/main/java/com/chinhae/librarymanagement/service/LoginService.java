package com.chinhae.librarymanagement.service;

import com.chinhae.librarymanagement.form.LoginForm;
import com.chinhae.librarymanagement.result.LoginResult;
import com.chinhae.librarymanagement.result.Result;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/7/9 02:40
 * @version: 1.0
 */
public interface LoginService {
    public LoginResult login(LoginForm loginForm);


    Result validateUserCredentials(String userName, String password);
}
