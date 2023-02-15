package uz.pdp.libraryapp.category;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    public void create(Category category) {
        String sql = "insert into categories (name, description) values(?,?);";
        jdbcTemplate.update(sql, category.getName(), category.getDescription());
    }

    public List<CategoryDto> read() {
        String sql = "select c.id, c.name from categories c;";
        return jdbcTemplate.query(sql, (rs, row) -> {
                    return CategoryDto.builder()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .build();
                }
        );
    }

    public void update(Category category) {
        String sql = "update categories set name = ? , description = ? where id = ?;";
        jdbcTemplate.update(sql, category.getName(), category.getDescription(), category.getId());
    }

    public int delete(int id) {
        String sql = "delete from categories where id = ?;";
        try {
            jdbcTemplate.update(sql, id);
            return 1;
        } catch (DataAccessException e) {
            return 0;
        }
    }

    public Category readById(int id) {
        String sql = "select * from categories where id = " + id + ";";
        return jdbcTemplate.query(sql, rs -> {
            rs.next();
            return Category.builder()
                    .id(rs.getInt(1))
                    .name(rs.getString(2))
                    .description(rs.getString(3))
                    .build();
        });
    }
}
