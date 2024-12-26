package utils;

public enum DateInputFormat {
    DD_MM_YYYY("dd/MM/yyyy"),
    MM_DD_YYYY("MM/dd/yyyy"),
    YYYY_MM_DD("yyyy/MM/dd");

    String pattern;

    DateInputFormat(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
