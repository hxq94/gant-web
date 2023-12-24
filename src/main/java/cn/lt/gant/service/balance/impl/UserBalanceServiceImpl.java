package cn.lt.gant.service.balance.impl;

import cn.lt.gant.dal.dao.balance.UserBalanceDao;
import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.entity.main.balance.UserBalance;
import cn.lt.gant.service.balance.UserBalanceService;
import cn.lt.gant.service.base.impl.BaseServiceImpl;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * UserBalanceService
 * 
 * @author huyunfei 2021-3-30
 * @since 南阳理工学院
 */
@Service
@Slf4j
public class UserBalanceServiceImpl extends BaseServiceImpl<UserBalance> implements UserBalanceService {
    
    /**
     * UserBalanceDao
     */
    @Resource
    private UserBalanceDao userBalanceDao;

    /**
     * Mapper初始化
     *
     * @return
     */
    @Override
    protected BaseDao<UserBalance> getDao() {
        return userBalanceDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateCount(UserBalance userBalance)  {
        userBalanceDao.updateCount(userBalance);

//        try {
////            TimeUnit.SECONDS.sleep(2);
            log.info("扣款成功");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
            System.out.println(1/0);

    }
}