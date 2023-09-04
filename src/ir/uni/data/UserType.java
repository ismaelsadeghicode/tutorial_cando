package ir.uni.data;

public enum UserType {
    ADMIN(1), CLIENT(2), GUEST(3);

    private int code;

    UserType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
