package katas;

class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {

        int totalPop = p0;
        int year = 0;

        while (totalPop < p){
            totalPop = (int) (totalPop + totalPop*percent/100 + aug);
            year ++;
        }

        return year;
    }
}
