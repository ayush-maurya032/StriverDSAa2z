/*
 * Calculate Score After Performing Instructions
Solved
Medium
4 pt.
You are given two arrays, instructions and values, both of size n.

You need to simulate a process based on the following rules:

You start at the first instruction at index i = 0 with an initial score of 0.
If instructions[i] is "add":
Add values[i] to your score.
Move to the next instruction (i + 1).
If instructions[i] is "jump":
Move to the instruction at index (i + values[i]) without modifying your score.
The process ends when you either:

Go out of bounds (i.e., i < 0 or i >= n), or
Attempt to revisit an instruction that has been previously executed. The revisited instruction is not executed.
Return your score at the end of the process.

 

Example 1:

Input: instructions = ["jump","add","add","jump","add","jump"], values = [2,1,3,1,-2,-3]

Output: 1

Explanation:

Simulate the process starting at instruction 0:

At index 0: Instruction is "jump", move to index 0 + 2 = 2.
At index 2: Instruction is "add", add values[2] = 3 to your score and move to index 3. Your score becomes 3.
At index 3: Instruction is "jump", move to index 3 + 1 = 4.
At index 4: Instruction is "add", add values[4] = -2 to your score and move to index 5. Your score becomes 1.
At index 5: Instruction is "jump", move to index 5 + (-3) = 2.
At index 2: Already visited. The process ends.
Example 2:

Input: instructions = ["jump","add","add"], values = [3,1,1]

Output: 0

Explanation:

Simulate the process starting at instruction 0:

At index 0: Instruction is "jump", move to index 0 + 3 = 3.
At index 3: Out of bounds. The process ends.
Example 3:

Input: instructions = ["jump"], values = [0]

Output: 0

Explanation:

Simulate the process starting at instruction 0:

At index 0: Instruction is "jump", move to index 0 + 0 = 0.
At index 0: Already visited. The process ends.
 

Constraints:

n == instructions.length == values.length
1 <= n <= 105
instructions[i] is either "add" or "jump".
-10^5 <= values[i] <= 10^5
 */

public class CalScore{


public static void main(String[] args) {
        String[] instructions = {"jump","add","add"}; int[] values = {3,1,1};
        System.out.println(calculateScore(instructions, values));
    }
public static long calculateScore(String[] instructions, int[] values) {
    int n = values.length;
    int[] flag = new int[n];
    long totalscore = 0;
    int i = 0;

    while (i >= 0 && i < n && flag[i] == 0) {
        int currentindex = i;

        if (instructions[i].equals("add")) {
            totalscore += values[i];
            i = i + 1;
        } else if (instructions[i].equals("jump")) {
            i = i + values[i];
        }

        flag[currentindex] = 1; // mark visited after the instruction is executed
    }

    return totalscore;
}

}