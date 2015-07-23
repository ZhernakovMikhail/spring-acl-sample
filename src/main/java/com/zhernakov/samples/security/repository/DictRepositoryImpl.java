package com.zhernakov.samples.security.repository;

import com.zhernakov.samples.security.model.Dict;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Misha on 21.07.2015.
 */

@Repository("dictRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class DictRepositoryImpl implements SecuredRepository<Dict> {

    final static RowMapper<Dict> DICT_ROW_MAPPER = new RowMapper<Dict>() {
        @Override
        public Dict mapRow(ResultSet rs, int i) throws SQLException {
            Dict dict = new Dict(rs.getLong(1));
            dict.setName(rs.getString(2));
            return dict;
        }
    };

    JdbcTemplate jdbcTemplate;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<Dict> getAll(Object... args) {
        Assert.isTrue(ArrayUtils.isEmpty(args), "Параметры не требуются");
        final Collection<Dict> elements = jdbcTemplate.query("select id, name from dict", DICT_ROW_MAPPER);
        return elements;
    }

    @Override
    public Dict getById(Object... args) {
        Assert.notNull(args, "Требуется один параметр id");
        Assert.isTrue(args.length == 1, "Требуется один параметр id");
        Long id = (Long) args[0];
        return jdbcTemplate.queryForObject("select id, name from dict where id = ?", DICT_ROW_MAPPER, id);
    }

    @Override
    public Dict update(final Dict object) {
        jdbcTemplate.update("UPDATE dict SET name = ? where id = ?", object.getName(), object.getId());
        return object;
    }

    @Override
    public Dict add(final Dict object) {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.update(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement("INSERT INTO dict (name) VALUES (?)");
                        ps.setObject(1, object.getName(), Types.VARCHAR);
                        return ps;
                    }
                });
                object.setId(jdbcTemplate.queryForObject("call identity()", Long.class));
            }
        });
        return object;
    }

    @Override
    public Dict delete(final Dict object) {
        jdbcTemplate.update("DELETE from dict WHERE id = ?", object.getId());
        return object;
    }
}
