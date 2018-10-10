package com.ljm.springbootdemo.sql.jdpctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class HomeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List getList(){
        String sql = "select * from home";
        return jdbcTemplate.query(sql, new RowMapper<Home>() {
            @Override
            public Home mapRow(ResultSet rs, int rowNum) throws SQLException {
                Home home = new Home();
                home.setAddr(rs.getString("addr"));
                home.setHomeid(rs.getInt("homeid"));
                home.setPartition(rs.getString("partition"));
                home.setPhone(rs.getString("phone"));
                return home;
            }
        });
    }
}
