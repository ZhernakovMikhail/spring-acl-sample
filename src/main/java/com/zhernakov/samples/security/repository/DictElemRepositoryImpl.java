package com.zhernakov.samples.security.repository;

import com.zhernakov.samples.security.model.DictElem;
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

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by Misha on 21.07.2015.
 */

@Repository("dictElemRepository")
@Transactional(propagation = Propagation.REQUIRED)
public class DictElemRepositoryImpl implements SecuredRepository<DictElem> {

    public static final String INSERT_INTO_DICT_ELEM_DICT_ID_NAME_VALUES = "INSERT INTO dict_elem (dict_id, name) VALUES (?, ?)";

    final static RowMapper<DictElem> DICT_ELEM_ROW_MAPPER = new RowMapper<DictElem>() {
        @Override
        public DictElem mapRow(ResultSet rs, int i) throws SQLException {
            DictElem elem = new DictElem(rs.getLong(1), rs.getLong(2));
            elem.setName(rs.getString(3));
            return elem;
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
    public Collection<DictElem> getAll(Object... args) {
        long dictId = (long) args[0];
        final List<DictElem> elements = jdbcTemplate.query("select id, dict_id, name from dict_elem where dict_id = ?", DICT_ELEM_ROW_MAPPER, dictId);
        return elements;
    }

    @Override
    public DictElem getById(Object... args) {
        long id = (long) args[0];
        long dictId = (long) args[1];
        return jdbcTemplate.queryForObject("select id, dict_id, name from dict_elem where dict_id = ? and id = ?", DICT_ELEM_ROW_MAPPER, dictId, id);
    }

    @Override
    public DictElem update(final DictElem object) {
        jdbcTemplate.update("UPDATE dict_elem SET name = ? where dict_id = ? and id = ?", object.getName(), object.getDictId(), object.getId());
        return object;
    }

    @Override
    public DictElem add(final DictElem object) {

        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.update(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(INSERT_INTO_DICT_ELEM_DICT_ID_NAME_VALUES);

                        ps.setObject(1, object.getDictId(), Types.NUMERIC);
                        ps.setObject(2, object.getName(), Types.VARCHAR);

                        return ps;
                    }
                });
                object.setId(jdbcTemplate.queryForObject("call identity()", Long.class));
            }
        });

        return object;
    }

    @Override
    public DictElem delete(final DictElem object) {
        jdbcTemplate.update("DELETE from dict_elem WHERE dict_id = ? and id = ?", object.getDictId(), object.getId());
        return object;
    }
}
