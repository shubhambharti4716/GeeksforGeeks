//{ Driver Code Starts
//Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;



process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .trim()
    .split("\n")
    .map((string) => {
      return string.trim();
    });

  main();
});

function readLine() {
  return inputString[currentLine++];
}


function main() {
  let t = parseInt(readLine());
  let i = 0;
 
  for (; i < t; i++) {
    let s = readLine().trim();
    let obj = new Solution();
    let res = obj.printMinNumberForPattern(s);
    console.log(res);
  }

}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {string} s
 * @return {string} 
*/

class Solution {
   printMinNumberForPattern(s){
    let curr_max = 0;
    let last_entry = 0;
    let ans = "";

    for (let i = 0; i < s.length; i++) {
      let noOfNextD = 0;

      switch(s[i]) {
        case 'I':
          let j = i + 1;
          while (s[j] == 'D' && j < s.length) {
            noOfNextD++;
            j++;
          }

          if (i == 0) {
            curr_max = noOfNextD + 2;
            ++last_entry;
            ans += (last_entry);
            ans += (curr_max);
            last_entry = curr_max;
          } else {
            curr_max = curr_max + noOfNextD + 1;
            last_entry = curr_max;
            ans += (last_entry);
          }

          for (let k = 0; k < noOfNextD; k++) {
            --last_entry;
            ans += (last_entry);
            i++;
          }
          break;

        case 'D':
          if (i == 0) {
            let j = i + 1;
            while (s[j] == 'D' && j < s.length) {
              noOfNextD++;
              j++;
            }

            curr_max = noOfNextD + 2;
            ans += (curr_max);
            ans += (curr_max - 1);
            last_entry = curr_max - 1;
          } else {
            ans += (last_entry - 1);
            last_entry--;
          }
          break;
      }
    }
    return ans;
  }
}