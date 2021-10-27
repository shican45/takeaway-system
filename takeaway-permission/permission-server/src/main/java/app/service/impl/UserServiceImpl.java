package app.service.impl;

import app.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.User;
import domain.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-27 17:20:03
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

