package cn.lt.gant.service.user;

import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.service.base.BaseService;

/**
 * UserService
 *
 * @author Administrator 2019-6-27
 * @since 南阳理工学院
 */
public interface UserService extends BaseService<User> {
    void updateById();

    boolean updateById2();

    void asyncSendMessageAfterTransactionCommit();

    void selectList();
}