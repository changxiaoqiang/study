package com.demo.Enum;

public enum Week {
    MONDAY("周一"), TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    // 成员变量
    private String name;
    private int index;

    Week() {
    }

    Week(String name) {
        this.name = name;
    }

    private Week(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Week c : Week.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
