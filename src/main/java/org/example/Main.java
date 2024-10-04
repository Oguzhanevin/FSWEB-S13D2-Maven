package org.example;

public class Main {
    public static void main(String[] args) {
        // Palindrom testleri
        System.out.println(isPalindrome(-1221));  // false
        System.out.println(isPalindrome(707));   // true
        System.out.println(isPalindrome(11212)); // false

        // Mükemmel sayı testleri
        System.out.println(isPerfectNumber(6));   // true (1 + 2 + 3 = 6)
        System.out.println(isPerfectNumber(28));  // true (1 + 2 + 4 + 7 + 14 = 28)
        System.out.println(isPerfectNumber(5));   // false (1)
        System.out.println(isPerfectNumber(-1));  // false (parametre 0'dan küçük olamaz)

        // Sayıları kelimelere dökme testleri
        System.out.println(numberToWords(123));  // "One Two Three"
        System.out.println(numberToWords(1010)); // "One Zero One Zero"
        System.out.println(numberToWords(-12));  // "Invalid Value"
        System.out.println(numberToWords(0));    // "Zero"
    }

    // Palindrom kontrolü yapan metod
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }

        int original = num;
        int reversed = 0;

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }

        return original == reversed;
    }

    // Mükemmel sayı kontrolü yapan metod
    public static boolean isPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }

        int sum = 0;

        // Sayının bölenlerini toplama
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        // Eğer bölenlerin toplamı sayıya eşitse, sayı mükemmeldir
        return sum == num;
    }

    // Sayıyı kelimelere döken metod
    public static String numberToWords(int num) {
        // Sayı 0'dan küçükse Invalid Value döndürür
        if (num < 0) {
            return "Invalid Value";
        }

        // Sayı sıfır ise Zero döndürüyoruz
        if (num == 0) {
            return "Zero";
        }

        // Sayının basamaklarını string olarak çevireceğiz
        String numberAsString = Integer.toString(num);
        StringBuilder result = new StringBuilder();

        // Her basamağın karşılığını yazalım
        for (int i = 0; i < numberAsString.length(); i++) {
            char digit = numberAsString.charAt(i);

            // Her rakamı karşılık gelen kelimeye çeviriyoruz
            switch (digit) {
                case '0': result.append("Zero "); break;
                case '1': result.append("One "); break;
                case '2': result.append("Two "); break;
                case '3': result.append("Three "); break;
                case '4': result.append("Four "); break;
                case '5': result.append("Five "); break;
                case '6': result.append("Six "); break;
                case '7': result.append("Seven "); break;
                case '8': result.append("Eight "); break;
                case '9': result.append("Nine "); break;
            }
        }

        // Sonundaki fazladan boşluğu temizliyoruz
        return result.toString().trim();
    }
}
