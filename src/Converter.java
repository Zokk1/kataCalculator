class Converter {

    static int toArabic(String number) {
        int temp = 0;
        for (Roman r : Roman.values())
            if (r.name().equals(number)) {
                temp = r.value;

            }
             return temp;
    }

    static String converterArabToRome(int input) {

        StringBuilder arabToRome = new StringBuilder();
        while (input >= 100) {
            arabToRome.append("C");
            input -= 100;
        }
        while (input >= 90) {
            arabToRome.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            arabToRome.append("L");
            input -= 50;
        }
        while (input >= 40) {
            arabToRome.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            arabToRome.append("X");
            input -= 10;
        }
        while (input >= 9) {
            arabToRome.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            arabToRome.append("V");
            input -= 5;
        }
        while (input >= 4) {
            arabToRome.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            arabToRome.append("I");
            input -= 1;
        }
        return arabToRome.toString();
    }


}
