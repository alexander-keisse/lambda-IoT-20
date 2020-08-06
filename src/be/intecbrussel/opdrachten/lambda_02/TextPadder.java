package be.intecbrussel.opdrachten.lambda_02;

public class TextPadder {

    private final int size;

    public TextPadder(int size) {
        this.size = size;
    }

    public String pad(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (size - s.length()); i++) {
            sb.append(' ');
        }
        sb.append(s);
        return sb.toString();
    }
}
