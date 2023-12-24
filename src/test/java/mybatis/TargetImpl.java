package mybatis;

public class TargetImpl implements Target {
    @Override
    public void execute() {
        System.out.println("mybatis.TargetImpl#execute");
    }
}
