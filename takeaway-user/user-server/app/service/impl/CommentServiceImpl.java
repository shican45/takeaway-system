package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import .dao.CommentDao;
import .entity.Comment;
import .service.CommentService;
import org.springframework.stereotype.Service;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2021-10-26 09:57:22
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {

}

