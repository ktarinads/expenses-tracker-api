package com.tutoriais.expensestrackerapi.repositories;

import com.tutoriais.expensestrackerapi.domain.User;
import com.tutoriais.expensestrackerapi.exceptions.EtAuthException;

public interface UserRepository {
    Integer create(String firsName, String lastName, String email, String password) throws EtAuthException;
    User findByEmailAndPassword(String email, String password) throws EtAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userID);
}
