package com.springboot.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IntArrayHandler extends BaseTypeHandler<int[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, int[] ints, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i1 : ints){
            sb.append(i1).append(",");
        }
        String st = sb.toString().substring(0,sb.length()-1);
        st=st+"]";
        preparedStatement.setString(i,st);
    }

    @Override
    public int[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sting = resultSet.getString(s);
        if (sting != null && sting.length() > 1) {
            String substring = sting.substring(1, sting.length() - 1);
            String[] array = substring.split(",");
            int intArray[] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                intArray[i] = Integer.parseInt(array[i]);
            }
            return intArray;
        } else {
            return null;
        }
    }

    @Override
    public int[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new int[0];
    }

    @Override
    public int[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new int[0];
    }
}
