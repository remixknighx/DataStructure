/**
 * Created by wangjf on 2017/8/1 0001.
 */

var nums1 = new Array();
nums1[0] = 1;
nums1[1] = 2;
nums1[2] = 2;
nums1[3] = 1;
var nums2 = new Array();
nums2[0] = 2;
nums2[1] = 2;

var intersection = function(nums1, nums2) {
    var length = nums1.length < nums2.length? nums1.length: nums2.length;
    var intersectionList = new Array();

    for(var i = 0; i < length; i++) {
        if (nums1 [i] == nums2[i]) {
            intersectionList.push(nums1[i]);
        }
    }

    return intersectionList;
};

var result = intersection(nums1, nums2);
for(var j = 0; j < result.length; j ++) {
    console.log(result.pop());
}



