package ro.foretech.vehicle;

public enum Color {
    BLACK("negru"),
    WHITE("alb"),
    GREEN("verde"),
    YELLOW("galben");

    private String color;

    private Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' +
                '}';
    }
}
