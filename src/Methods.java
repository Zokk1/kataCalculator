class Metods {
      static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static void inputChecker(String[] input) throws Exception {
        if (input.length==0){
            throw new Exception("т.к. строка не является математической операцией");
        }
    }
}
