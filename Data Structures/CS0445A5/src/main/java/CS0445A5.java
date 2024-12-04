public class CS0445A5 {
    public static void main (String[] args) {
        System.out.println("===== BinSort =====");
        BinSort.main(null);
        
        System.out.println("===== Esrom =====");
        String[] esromArgs = { "." };
        Esrom.main(esromArgs);

        System.out.println("===== Morse =====");
        try {
            Morse.main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
