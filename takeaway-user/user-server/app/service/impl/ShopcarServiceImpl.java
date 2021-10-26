package service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import .dao.ShopcarDao;
import .entity.Shopcar;
import .service.ShopcarService;
import org.springframework.stereotype.Service;

/**
 * (Shopcar)表服务实现类
 *
 * @author makejava
 * @since 2021-10-26 09:57:20
 */
@Service("shopcarService")
public class ShopcarServiceImpl extends ServiceImpl<ShopcarDao, Shopcar> implements ShopcarService {

}

