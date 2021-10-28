package domain.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import domain.User;
import org.springframework.stereotype.Repository;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-27 17:20:02
 */
@Repository
public interface UserDao extends BaseMapper<User> {

}

