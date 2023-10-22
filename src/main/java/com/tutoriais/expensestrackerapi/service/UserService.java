package com.tutoriais.expensestrackerapi.service;

import com.tutoriais.expensestrackerapi.domain.User;
import com.tutoriais.expensestrackerapi.exceptions.EtAuthException;

import javax.naming.AuthenticationException;

public interface UserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
