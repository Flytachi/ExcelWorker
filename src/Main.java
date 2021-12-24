public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Excel Worker.");

        String [][] ware = {
                {"phone", "400", "100", ""}
        };

        for(String[] data: ware) data[3] = String.valueOf( Integer.parseInt(data[2].trim()) / ((Integer.parseInt(data[1].trim()) + Integer.parseInt(data[2].trim())) / 100.0) );

        for(String[] data: ware) {
            int all = Integer.parseInt(data[1].trim()) + Integer.parseInt(data[2].trim());
            System.out.println("Товар   : "+ data[0]);
            System.out.println("Осталось: "+ data[1]);
            System.out.println("Продано : "+ data[2]);
            System.out.println("Процент : "+ data[3]);
        }
    }
}
