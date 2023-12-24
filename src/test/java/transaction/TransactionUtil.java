package transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import util.SpringContextHolder;

public class TransactionUtil {


    public static void commitAndExecute(TransactionProcess transactionProcess) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    transactionProcess.process();
                }
            });
        } else {
            transactionProcess.process();
        }
    }

    public static void transactionAndCommit(TransactionProcess transactionProcess) {
        PlatformTransactionManager platformTransactionManager = SpringContextHolder.getBean(PlatformTransactionManager.class);
        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = platformTransactionManager.getTransaction(defaultTransactionDefinition);
        try {
            transactionProcess.process();
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
        }


    }
}
