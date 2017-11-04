/**
 * 443. String Compression
 * @link https://leetcode.com/problems/string-compression/description/
 *
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    let newChars = "";
    let oldChar = chars[0];
    newChars += oldChar;

    let count = 1;

    for (let i = 1; i < chars.length; i++) {
        if(chars[i] == oldChar){
            count++;
        } else {
            if(count !== 1) {
                newChars+= count;
            }

            oldChar = chars[i];
            newChars += oldChar;
            count = 1;
        }
    }

    if(count !== 1) {
        newChars += count;
    }

    return newChars.split("");
};

var chars = ["a","a","b","b","c","c","c"];
console.log(compress(chars));