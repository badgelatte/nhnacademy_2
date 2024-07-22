public enum Month {
    January("1월"),
    Feburary("2월"),
    March("3월"),
    April("4월"),
    May("5월"),
    June("6월"),
    July("7월"),
    August("8월"),
    September("9월"),
    October("10월"),
    November("11월"),
    December("12월");

    private String korName;

    private Month(){}

    private Month(String korName) {
        this.korName = korName;
    }

    public String getKorName() {
        return this.korName;
    }
}
