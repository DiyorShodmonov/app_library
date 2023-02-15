package uz.pdp.libraryapp.language;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class LanguageDao {
    private final JdbcTemplate jdbcTemplate;
    public void create(Language language) {
        String sql = "insert into languages (lang) values(?);";
        jdbcTemplate.update(sql, language.getName());
    }
    public List<Language> read() {
        String sql = "select l.id, l.lang from languages l;";
        return jdbcTemplate.query(sql, (rs, row) ->{
            return Language.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .build();
                }
        );
    }
    public void update(Language language) {
        String sql = "update languages set lang = ? where id = ?;";
        int update = jdbcTemplate.update(sql,language.getName(), language.getId() );
    }
    public int delete(int id) {
        String sql = "delete from languages where id = ?;";
        try {
            jdbcTemplate.update(sql, id);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }
    public Language readById(int id) {
        String sql = "select * from languages where id = " + id + ";";
        return jdbcTemplate.query(sql, rs -> {
            rs.next();
            return Language.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .build();
        });
    }
}
