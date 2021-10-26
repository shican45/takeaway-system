package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import .dao.UserDao;
import .entity.User;
import .service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-10-26 09:57:18
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

