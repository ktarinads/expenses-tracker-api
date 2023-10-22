package com.tutoriais.expensestrackerapi.repositories;

import com.tutoriais.expensestrackerapi.domain.Category;
import com.tutoriais.expensestrackerapi.exceptions.EtBadRequestException;
import com.tutoriais.expensestrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;
    Category findById (Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws EtBadRequestException;
    void update(Integer userId, String title, String description) throws EtBadRequestException;
    void removeById(Integer userId, Integer categoryId);
}
