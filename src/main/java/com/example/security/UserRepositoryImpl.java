package com.example.security;

import com.example.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Date;

@Component
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(@Qualifier("dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getCountOfEntries(String login, Date dateFrom, Date dateTo) {
        return jdbcTemplate.queryForObject("select get_entries(?,?,?) as count", new Object[] {login, dateFrom, dateTo}, new UserMapper());
    }
}
