package katas;

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers){

        String phoneNumber = "(";

        for (int i = 0; i < 3; i++) {
            phoneNumber += numbers[i];
        }

        phoneNumber += ") ";

        for (int i = 3; i < 6; i++) {
            phoneNumber += numbers[i];
        }

        phoneNumber += "-";

        for (int i = 6; i < 10; i++) {
            phoneNumber += numbers[i];
        }

        return phoneNumber;
    }
}
