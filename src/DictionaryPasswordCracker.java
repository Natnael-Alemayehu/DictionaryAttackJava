import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DictionaryPasswordCracker {
    public static void main(String[] args) {
        String md5 = HashFinder("5d41402abc4b2a76b9719d911017c592" , "MD5");

        String sha1 = HashFinder("9009b730f26e909d049a4a0c3612e3c61160f37f" , "SHA-1");

        String sha256 = HashFinder("b22d1d8fe5752533954028172c9bf3ac01b57f40c82946a3e7b1eaff389e2b87" , "SHA-256");
    }
    public static String HashFinder(String hash , String HashType){
        Scanner s  = null;
        String finalWord = "";
        try{
            s = new Scanner(new File("C:\\Users\\Natnael\\Desktop\\N\\School\\4th year 1st semester\\Security\\Project\\Proj\\src\\cain.txt"));
            while (s.hasNextLine()){
                String word = s.nextLine();

                if (HashType.equals("MD5")){
                    String h = MD5Hash(word);
                    if (hash.equals(h)) {
                        System.out.println("Cracked MD5 hash : " + word);
                        finalWord = word;
                    }
                }

                if (HashType.equals("SHA-1")){
                    String h = SHA_1Hash(word);
                    if (hash.equals(h)) {
                        System.out.println("Cracked SHA-1 hash : " + word);
                        finalWord = word;
                    }
                }

                if (HashType.equals("SHA-256")){
                    String h = SHA_256Hash(word);
                    if (hash.equals(h)) {
                        System.out.println("Cracked SHA-256 hash : " + word);
                        finalWord = word;
                    }
                }

            }
            if (finalWord.equals("")){
                System.out.println("There is no match!");
            }
        } catch (FileNotFoundException | NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
        return finalWord;
    }


    public static String MD5Hash(String text) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger bigInt = new BigInteger(1,messageDigest);
        return bigInt.toString(16);
    }

    public static String SHA_256Hash(String text) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger bigInt = new BigInteger(1,messageDigest);
        return bigInt.toString(16);
    }

    public static String SHA_1Hash(String text) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] messageDigest = md.digest(text.getBytes());
        BigInteger bigInt = new BigInteger(1,messageDigest);
        return bigInt.toString(16);
    }
}
