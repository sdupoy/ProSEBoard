package fr.eseo.ld.proseboard.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisUtilRedmine {
    private static SqlSessionFactory factory;
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisUtilRedmine.class);

    private MyBatisUtilRedmine() {
    }

    static {
        Reader reader = null;
        try {
           reader = Resources.getResourceAsReader("/fr/eseo/ld/proseboard/mybatis/configRedmine.xml");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }
}
