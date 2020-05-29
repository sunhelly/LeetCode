package leetcode.algorithms;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
      Stack<String> subStringStack = new Stack<>();
      Stack<Integer> countStack = new Stack<>();
      int i = 0;
      while (i < s.length()) {
        if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
          int num = 0;
          while (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            num = num * 10 + (s.charAt(i++) - '0');
          }
          countStack.push(num);
        } else {
          if (s.charAt(i) != ']') {
            subStringStack.push(s.substring(i, i + 1));
          } else {
            StringBuilder subString = new StringBuilder();
            while (!subStringStack.isEmpty()) {
              String c = subStringStack.pop();
              if (!c.equals("[")) {
                subString.insert(0, c);
              } else {
                break;
              }
            }
            String sub = subString.toString();
            int count = countStack.pop();
            for (int j = 0; j < count - 1; j++) {
              subString.append(sub);
            }
            subStringStack.push(subString.toString());
          }
          i++;
        }

      }
      StringBuilder result = new StringBuilder();
      while (!subStringStack.isEmpty()) {
        result.insert(0, subStringStack.pop());
      }
      return result.toString();
    }
}
