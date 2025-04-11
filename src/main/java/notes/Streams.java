package notes;

import java.util.stream.Stream;

public class Streams {
    public void streams() {

        String string = "abcd";
        Stream<Character> characterStream = string.chars().mapToObj(chararacter -> (char) chararacter);
    }
}
