package cn.lt.gant.service.user.impl;

import cn.lt.gant.dal.dao.base.BaseDao;
import cn.lt.gant.dal.dao.user.UserDao;
import cn.lt.gant.dal.entity.main.balance.UserBalance;
import cn.lt.gant.dal.entity.main.user.User;
import cn.lt.gant.service.balance.UserBalanceService;
import cn.lt.gant.service.base.impl.BaseServiceImpl;
import cn.lt.gant.service.user.UserService;
import cn.lt.gant.service.util.TransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.ProxyGenerator;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * UserService
 *
 * @author Administrator 2019-6-27
 * @since 南阳理工学院
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    /**
     * UserDao
     */
    @Resource
    private UserDao userDao;

    @Autowired
    private UserBalanceService userBalanceService;
    @Autowired
    private UserService userService;

    @Resource(name = "hyfThreadPoolExecutor")
    private TaskExecutor taskExecutor;

    /**
     * Mapper初始化
     *
     * @return
     */
    @Override
    protected BaseDao<User> getDao() {
        return userDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateById() {
        User user = new User();
        user.setId(1);
        user.setPassword("99999");
        userDao.updateById(user);

        UserBalance userBalance = new UserBalance();
        userBalance.setCount(666L);
        userBalance.setId(1);
        userBalanceService.updateCount(userBalance);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean updateById2() {
        System.out.println(Thread.currentThread().getName() + "第二层事物");
        User user = new User();
        user.setId(2);
        user.setPassword("2");

//        try{
        userDao.updateById(user);

        UserBalance userBalance = new UserBalance();
        userBalance.setCount(1L);
        userBalance.setId(1);

        userBalanceService.updateCount(userBalance);

        return true;

//            System.out.println(1/0);
//        }catch (Exception e){
//            throw new RuntimeException();
//        }

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() ->
        {
            try {
                int a = 1 / 0;
            } catch (Throwable ee) {
                System.out.println("Stack invoke depth 1111 ");
                throw ee;
            }
            ;
        });

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void asyncSendMessageAfterTransactionCommit() {
        UserBalance userBalance = new UserBalance();
        userBalance.setCount(33378L);
        userBalance.setId(1);
        TransactionUtil.commitAndExecute(() -> taskExecutor.execute(() -> sendMessage()));

//        TransactionUtil.transactionAndCommit(()->updateById2());

//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread().getName() + "第一个层事物");
        User user = new User();
        user.setId(1);
        user.setPassword("1");
        userDao.updateById(user);
        String DEFAULT_CLASS_NAME = "$Proxy";

        byte[] $Proxy4s = ProxyGenerator.generateProxyClass("$Proxy4", UserServiceImpl.class.getInterfaces());
        FileOutputStream out = null;

        try {
            String filePath = "./" + DEFAULT_CLASS_NAME + ".class";
            out = new FileOutputStream(filePath);
            out.write($Proxy4s);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) out.close();
            } catch (IOException e) {
                //ignore
            }
        }


        //        userService.updateById2();
        ExecutorService executorService = Executors.newSingleThreadExecutor();


//        try {
//            submit.get();
//        }catch (ArithmeticException e){
//            System.err.println("sdsdsdsds"+e);
//        }catch (UnexpectedRollbackException e){
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {


//
        log.info("添加用户完毕");
//        userBalanceService.updateCount(userBalance);
        try {
//            userService.updateById2();
        } catch (Exception e) {
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            throw new RuntimeException();
        }

    }

    @Override
    public void selectList() {
        userDao.selectList();
    }

    private void sendMessage() {
        log.info("全部执行 发送消息");
//        System.out.println(1/0);
    }


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateCount(UserBalance userBalance) {
        userBalanceService.updateCount(userBalance);
        System.out.println(1 / 0);
    }
}