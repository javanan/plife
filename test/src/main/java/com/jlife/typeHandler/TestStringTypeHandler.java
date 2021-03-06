package com.jlife.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by chenjianan on 2016/11/10-17:00.
 * <p>
 * Describe:
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({String.class})
public class TestStringTypeHandler extends BaseTypeHandler<String> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {

        logger.info("使用我的TypeHandler");
        preparedStatement.setString(i, s);
    }

    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        logger.info("使用我的TypeHandler,ResultSet列名获取");
        return resultSet.getString(s);
    }

    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        logger.info("使用我的TypeHandler,ResultSet下标获取");
        return resultSet.getString(i);
    }

    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        logger.info("使用我的TypeHandler,callableStatement下标获取");
        return callableStatement.getString(i);
    }
}
