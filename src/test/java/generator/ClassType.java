package generator;

public enum ClassType {
    CONTROLLER("Controller"), SERVICE("Service"), DAO("Dao"), MAPPER("Mapper"), POJO("Pojo");

    private final String comment;

    private ClassType(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }
}
