package cn.lt.gant.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
public class TransactionUtil {
    public static void commitAndExecute(TransactionProcess transactionProcess){
        if(TransactionSynchronizationManager.isActualTransactionActive()){
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    transactionProcess.process();
                }

                @Override
                public void beforeCommit(boolean readOnly) {
                }
            });
        }else{
            transactionProcess.process();
        }
    }

    public static void transactionAndCommit(TransactionProcess transactionProcess){
        PlatformTransactionManager platformTransactionManager = SpringContextHolder.getBean(PlatformTransactionManager.class);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        defaultTransactionDefinition.setName("hyf-name");
        TransactionStatus status = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            transactionProcess.process();
            platformTransactionManager.commit(status);
        }catch (Exception e){
            platformTransactionManager.rollback(status);
        }
    }
}
