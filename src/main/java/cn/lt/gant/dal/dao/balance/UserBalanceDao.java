package cn.lt.gant.dal.dao.balance;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.entity.main.balance.UserBalance;

/**
 * UserBalanceDao
 * 
 * @author huyunfei 2021-3-30
 * @since 南阳理工学院
 */
public interface UserBalanceDao extends BaseDao<UserBalance> {
    void updateCount(UserBalance userBalance);
}