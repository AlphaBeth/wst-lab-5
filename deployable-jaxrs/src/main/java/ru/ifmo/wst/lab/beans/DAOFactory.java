package ru.ifmo.wst.lab.beans;

import lombok.Data;
import ru.ifmo.wst.lab1.dao.ExterminatusDAO;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@Data
@ApplicationScoped
public class DAOFactory {
    @Resource(lookup = "jdbc/exterminate")
    private DataSource dataSource;

    @Produces
    public ExterminatusDAO exterminatusDAO() {
        return new ExterminatusDAO(dataSource);
    }
}
