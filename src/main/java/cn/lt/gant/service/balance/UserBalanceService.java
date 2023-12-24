package cn.lt.gant.service.balance;

import cn.lt.gant.dal.entity.main.balance.UserBalance;
import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.service.base.BaseService;

/**
 * UserBalanceService
 * 
 * @author huyunfei 2021-3-30
 * @since 南阳理工学院
 */
public interface UserBalanceService extends BaseService<UserBalance> {

    void updateCount(UserBalance userBalance);
}