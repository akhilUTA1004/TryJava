
import tryouts.*;

void main() {
    IO.println("Hello and welcome!");

    for (int i = 1; i <= 5; i++) {
        IO.println("i = " + i);
    }

    String input = "swiss";

    TryString.findFirstNonRepeatedCharacterA1(input);
    TryString.findFirstNonRepeatedCharacterA2(input);
}
