package com.springboot.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StringArrayHandler extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        String st = "";
        if (strings != null && strings.length > 0) {
            for (String string : strings) {
                sb.append(string).append(",");
            }
            st = sb.toString().substring(0, sb.length() - 1);
        } else {
            st = sb.toString();
        }

        preparedStatement.setString(i,st);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        //String substring = sting.substring(1, sting.length()-1);
        String[] array = string.split(",");
        return array;
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sting = resultSet.getString(i);
        String[] array = sting.split(",");
        return array;
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
/*        String string = callableStatement.getString(i);
        String[] array = string.split(",");
        return array;*/
        return null;
    }
}
