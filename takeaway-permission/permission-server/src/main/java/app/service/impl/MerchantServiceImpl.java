package app.service.impl;

import app.service.MerchantService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import domain.Merchant;
import domain.dao.MerchantDao;
import org.springframework.stereotype.Service;

/**
 * (Merchant)表服务实现类
 *
 * @author makejava
 * @since 2021-10-27 17:20:04
 */
@Service("merchantService")
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, Merchant> implements MerchantService {

}

