package Leetcode;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
//
// Related Topics 数组
// 👍 561 👎 0
public class Q66 {
    public static int[] plusOne1(int[] digits) {
        boolean flag = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                if (digits[i] + 1 < 10) {
                    digits[i] = digits[i] + 1;
                    break;
                } else {
                    flag = true;
                    if (i == 0) {
                        int[] newdigits = new int[digits.length + 1];
                        newdigits[0] = 1;
                        newdigits[1] = 0;
                        digits = newdigits;
                    } else {
                        digits[i] = 0;
                    }
                }
            } else {
                if (i == 0) {
                    if (flag) {
                        if (digits[i] + 1 == 10) {
                            digits[i] = 0;
                            int[] newdigits = new int[digits.length + 1];
                            System.arraycopy(digits, 0, newdigits, 1, digits.length);
                            newdigits[0] = 1;
                            digits = newdigits;
                        } else {
                            digits[i] = digits[i] + 1;
                            flag = false;
                            break;
                        }
                    }
                } else {
                    if (digits[i] + 1 == 10) {
                        digits[i] = 0;
                        flag = true;
                    } else {
                        digits[i] = digits[i] + 1;
                        flag = false;
                        break;
                    }
                }
            }
        }
        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3, 9};
        int[] res = plusOne2(digits);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                sb.append(res[i]);
                sb.append(",");
            } else {
                sb.append(res[i]);
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
