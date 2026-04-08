public class Demo {
    public static void main(String[] args) {
        BaseballCards card1 = new BaseballCards("Babe Ruth", 1927);
        BaseballCards card2 = new BaseballCards("Babe Ruth", 1927);
        BaseballCards card3 = new BaseballCards("Derek Jeter", 2000);
        System.out.println(card1);
        System.out.println(card3);
        System.out.println("card1 equals card2: " + card1.equals(card2));
        System.out.println("card1 equals card3: " + card1.equals(card3));
    }
}