package com.example.security;

import java.sql.Date;

public interface UserRepository {

    User getCountOfEntries(String login, Date dateFrom, Date dateTo);
}
