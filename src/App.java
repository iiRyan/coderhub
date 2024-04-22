import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int[] arr1 = { 1, 2, 4, 5 };
        int[] arr2 = { 3, 4, 7, 11 };

        System.out.println(count_ones(21));
    }

    public static int number_sum(int num) {
        int sum = num;
        for (int i = 0; i < num; i++) {
            sum += i;
        }
        return sum;
    }

    public static boolean kSumSubset(int[] numArray, int k) {
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray.length; j++) {
                if ((numArray[i] + numArray[j]) == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int removeElement(int[] nums, int val) {
        // Initialize index i for writing elements in the array
        int i = 0;

        // Traverse the array from the start to end
        for (int j = 0; j < nums.length; j++) {
            // If the current element is not equal to the given value...
            if (nums[j] != val) {
                // ...copy it to the position of the 'write' index i...
                nums[i] = nums[j];
                // ...and increment the write index
                i++;
            }
            // If the current element equals val, it is skipped
        }

        // Return the number of elements not equal to val
        return i;
    }

    public static int[] findMaxMin(int[] myList) {
        int maximum = myList[0];
        int minimum = myList[0];
        for (int num : myList) {
            if (num > maximum) {
                maximum = num;
            } else if (num < minimum) {
                minimum = num;
            }
        }
        return new int[] { maximum, minimum };
    }

    public static String findLongestString(String[] stringList) {
        String ans = "";
        for (String element : stringList) {
            if (element.length() > ans.length()) {
                ans = element;
            }
        }

        return ans;
    }

    // Did not solve it myself.
    public static int repetitions(String s) {

        int maxRepeat = 0;
        int currentRepeat = 1;

        // Iterate through the characters of the string starting from the second
        // character
        for (int i = 1; i < s.length(); i++) {
            // Compare the current character with the previous one
            if (s.charAt(i) == s.charAt(i - 1)) {
                // If the current character is the same as the previous one, increment the
                // current repeat count
                currentRepeat++;
            } else {
                // If the current character is different from the previous one
                // Update the maximum repeating sequence length if necessary
                maxRepeat = Math.max(maxRepeat, currentRepeat);
                // Reset the current repeat count to 1 for the new character
                currentRepeat = 1;
            }
        }

        // Update the maximum repeating sequence length one last time (in case the
        // sequence ends with the longest repeating characters)
        maxRepeat = Math.max(maxRepeat, currentRepeat);

        return maxRepeat;

    }

    public static int sum_two_smallest_nums(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return min1 + min2;
    }

    // O(N^2) Not efficient.
    public static int[] sort_array(int[] my_array, String typeParam) {

        int temp = 0;
        for (int i = 0; i < my_array.length; i++) {
            for (int j = i + 1; j < my_array.length; j++) {
                if (my_array[i] < my_array[j] && typeParam.equals("B")) {
                    temp = my_array[i];
                    my_array[i] = my_array[j];
                    my_array[j] = temp;
                } else if (my_array[i] > my_array[j] && typeParam.equals("S")) {
                    temp = my_array[i];
                    my_array[i] = my_array[j];
                    my_array[j] = temp;
                }
            }
        }
        return my_array;
    }

    public static String operation(int num1, int num2) {

        int ans = 24;
        if (num1 + num2 == ans) {
            return "added";
        } else if (num1 * num2 == ans) {
            return "multiplied";
        } else if (num1 / num2 == ans) {
            return "divided";
        } else if (num1 - num2 == ans) {
            return "subtracted";
        }
        return "None";
    }

    public static boolean stringCheck(String[] value) {
        for (int i = 1; i < value.length; i++) {
            if (!value[0].equals(value[i])) {
                return false;
            }
        }
        return true;
    }

    public static String oddsVsEvens(int num) {

        int sumOdd = 0;
        int sumEven = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 == 0) {
                sumEven += digit;
            } else {
                sumOdd += digit;
            }
            num = num / 10;
        }

        if (sumEven == sumOdd)
            return "equal";

        return sumEven > sumOdd ? "even" : "odd";
    }

    public static int exponent_x(int number, int exponent) {
        if (exponent == 0)
            return 0;
        if (exponent == 1)
            return number;

        int count = 1;
        int newInt = 0;
        while (count < exponent) {

            number = count * number;
            count++;
        }

        return number;
    }

    public static void multiplication(int desiredNumber) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int answers = 0;
        int wrongAnswers = 0;
        int limit = 0;

        while (limit < 20) {
            int randomNumber = random.nextInt(9) + 1;
            System.out.print("What is " + desiredNumber + " * " + randomNumber + " : ");
            int theAnswer = desiredNumber * randomNumber;
            int userAnswer = input.nextInt();

            if (userAnswer == theAnswer) {
                System.out.println("Correct");
                answers++;
            } else {
                System.out.println("Wrong Answer");
                wrongAnswers++;
            }
            limit++;
        }
        System.out.println("Your Correct answers " + answers + "\n Your Wrong Answers: " + wrongAnswers);
    }

    public static int increasing_array(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i] < arr[i - 1]) {
                arr[i] += 1;
                count++;
            }
        }
        return count;
    }

    public static int reversGivenNumber(int number) {
        int temp = number;
        int reversed = 0;
        while (temp != 0) {
            int r = temp % 10; // Extract the last digit of the number
            reversed = reversed * 10 + r; // Append the extracted digit to the reversed number
            temp /= 10; // Remove the last digit from the original number
        }
        return reversed;
    }

    public static boolean isMirrored(int num) {
        return num == reversGivenNumber(num);
    }

    public static int getBiggestShared(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    return a[i];
                }
            }

        }
        return 0;
    }

    public static int count_ones(int decimal) {

        if (decimal == 0) {
            return 0; // Special case for 0
        }

        int binary = 0;
        int placeValue = 1;
        int count = 0;
        while (decimal > 0) {
            int remainder = decimal % 2; // Get the remainder when dividing by 2
            if (remainder == 1) {
                count++;
            }
            binary += remainder * placeValue; // Update the binary number by adding the remainder multiplied by its
                                              // place value
            decimal /= 2; // Divide the number by 2
            placeValue *= 10; // Update the place value for the next digit
        }
        return count; // Return the binary representation as an integer

    }

}
