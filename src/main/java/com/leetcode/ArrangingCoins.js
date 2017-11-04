/**
 * 441. Arranging Coins
 * @link https://leetcode.com/problems/arranging-coins/description/
 *
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    let row = 1;
    while (true) {
        if((n - row) < 0) {
            return --row;
        } else {
            n = n - row;
            row++;
        }
    }
};

console.log(arrangeCoins(8));