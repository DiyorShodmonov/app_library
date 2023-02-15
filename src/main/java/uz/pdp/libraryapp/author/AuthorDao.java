package uz.pdp.libraryapp.author;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorDao {
    private final JdbcTemplate jdbcTemplate;

    public void create(Author author) {

        String sql = "insert into authors (full_name,biography) values(?,?);";
        jdbcTemplate.update(sql, author.getFullName(), author.getBiography());
    }

    public List<AuthorDto> read() {
        String sql = "select a.id, a.full_name from authors a;";
        return jdbcTemplate.query(sql, (rs, row) ->
                AuthorDto.builder().authorId(rs.getInt(1)).authorFullName(rs.getString(2)).build()
        );
    }

    public void update(Author author) {
        String sql = "update authors set full_name = ?, biography = ? where id = ?;";
        int update = jdbcTemplate.update(sql, author.getFullName(), author.getBiography(), author.getId());
        System.out.println("update = " + update);
    }

    public int delete(int id) {
        String sql = "delete from authors where id = ?;";
        try {
            jdbcTemplate.update(sql, id);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public Author readById(int id) {
        String sql = "select * from authors where id = " + id + ";";
        return jdbcTemplate.query(sql, rs -> {
            rs.next();
            return Author.builder()
                    .id(rs.getInt(1))
                    .fullName(rs.getString(2))
                    .biography(rs.getString(3))
                    .build();
        });
    }


}
