package gh2;

import deque.ArrayDeque;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static final double CONCERT_A = 440.0;
    private static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static ArrayDeque<GuitarString> guitarStrings = new ArrayDeque<>();

    private static final double FREQUENCY_PARAMETER_A = 24.0;

    private static final double FREQUENCY_PARAMETER_B = 12.0;

    public static void main(String[] args) {
        createGuitarStrings();
        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = KEYBOARD.indexOf(key);
                if (index >= 0) {
                    guitarStrings.get(index).pluck();
                }
            }
            double sum = computeSamples();
            StdAudio.play(sum);
            advanceAllStrings();
        }
    }

    private static void createGuitarStrings() {
        int length = KEYBOARD.length();
        for (int i = 0; i < length; i++) {
            double frequency = CONCERT_A * Math.pow(2, (i - FREQUENCY_PARAMETER_A) / FREQUENCY_PARAMETER_B);
            guitarStrings.addLast(new GuitarString(frequency));
        }
    }

    private static double computeSamples() {
        int length = KEYBOARD.length();
        double sum = 0.0;
        for (int i = 0; i < length; i++) {
            sum += guitarStrings.get(i).sample();
        }
        return sum;
    }

    private static void advanceAllStrings() {
        int length = KEYBOARD.length();
        for (int i = 0; i < length; i++) {
            guitarStrings.get(i).tic();
        }
    }
}
