package cn.lt.gant.service.task;

import cn.lt.gant.service.task.base.BaseTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTask extends BaseTaskService {

    Logger logger = LoggerFactory.getLogger(TestTask.class);

    @Override
    protected void execute() {
        logger.debug("定时任务service....");
    }

    @Override
    protected Class<?> getSubClass() {
        return TestTask.class;
    }
}
