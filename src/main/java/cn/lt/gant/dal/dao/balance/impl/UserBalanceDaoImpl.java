package cn.lt.gant.dal.dao.balance.impl;

import cn.lt.gant.dal.dao.balance.UserBalanceDao;
import cn.lt.gant.dal.dao.base.impl.BaseDaoImpl;
import cn.lt.gant.dal.entity.main.balance.UserBalance;
import cn.lt.gant.dal.mapper.base.BaseMapper;
import cn.lt.gant.dal.mapper.main.balance.UserBalanceMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * UserBalanceDao
 * 
 * @author huyunfei 2021-3-30
 * @since 南阳理工学院
 */
@Repository
public class UserBalanceDaoImpl extends BaseDaoImpl<UserBalance> implements UserBalanceDao {
    
    /**
     * UserBalanceMapper
     */
    @Resource
    private UserBalanceMapper userBalanceMapper;

    /**
     * Mapper初始化
     *
     * @return
     */
    @Override
    protected BaseMapper<UserBalance> getMapper() {
        return userBalanceMapper;
    }

    @Override
    public void updateCount(UserBalance userBalance) {
        userBalanceMapper.updateByPrimaryKeySelective(userBalance);
    }
}