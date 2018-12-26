package com.example.security.Repository;

import com.example.security.User;

import java.sql.Date;

public interface UserRepository {

    User getCountOfEntries(String login, Date dateFrom, Date dateTo);
}
