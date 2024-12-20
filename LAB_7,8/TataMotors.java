public class TataMotors {
    public static String modelOfCategory(String category) {
        return
        switch (category.toUpperCase()) {
            case "SUV" -> "TATA SAFARI";
            case "SEDAN" -> "TATA INDIGO";
            case "ECONOMY" -> "TATA INDICA";
            case "MINI" -> "TATA NANO";
            default -> "Unknown category";
        };
    }

    public static void main(String[] args) {
        System.out.println(modelOfCategory("SUV"));
        System.out.println(modelOfCategory("ECONOMY"));
        System.out.println(modelOfCategory("SEDAN"));
        System.out.println(modelOfCategory("MINI"));
    }
}

