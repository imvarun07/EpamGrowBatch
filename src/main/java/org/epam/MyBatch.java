package org.epam;

public class MyBatch {
    public static void main(String[] args) {
       checkRotation("abcde","cdeab");
       checkRotation("abcde","abc");
    }


    public static void checkRotation(String str1, String str2) {

        //If length of strings are not equal they cannot be rotations of each other
        if (str1.length() != str2.length()) {
            System.out.println("Second string is not a rotation of first string");
        }
        else {
            //Concatenate str1 with str1 and store it in str1
            str1 = str1.concat(str1);

            //Check whether str2 is present in str1
            if (str1.contains(str2))
                System.out.println("Second string is a rotation of first string");
            else
                System.out.println("Second string is not a rotation of first string");
        }
    }
}