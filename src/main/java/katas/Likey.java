package katas;

public class Likey {
//    public static String whoLikesIt(String... names){
//        // String... =  vararg - variable argument
//
//        if (names.length == 0){
//            return "no one likes this";
//        } else if (names.length == 1) {
//            return names[0] + " likes this";
//        } else if (names.length == 2){
//            return names[0] + " and " + names[1] + " like this";
//        } else if (names.length == 3) {
//            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
//        } else {
//            String remaining = String.valueOf(names.length - 2);
//            return names[0] +", " + names[1] + " and " + remaining + " others like this";
//        }
//    }

    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
}
