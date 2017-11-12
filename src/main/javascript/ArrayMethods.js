/**
 * join() 将数组中所有元素都转化2为字符串并连接在一起
 * 返回最后生成的字符串
 */
!(function () {
    console.log(">>>>>>>>>>>> join() <<<<<<<<<<<<<");
    var a = [1, 2, 3];
    console.log(a.join());  // "1,2,3"
    console.log(a.join(" "));  // "1 2 3"
    console.log(a.join(""));  // "12
    console.log("=======================");
}());

/**
 * sort()方法将数组中的元素排序并返回排序后的数组
 */
(function () {
  console.log(">>>>>>>>>>>> sort() <<<<<<<<<<<<<");
  var a = new Array("banana", "cherry", "apple");
  a.sort();
  var b = [33, 4, 1111, 222];
  b.sort(function (a, b) {
      return b-a;
  })
  console.log(b.join(" "));
  console.log("=======================");
}());

/**
 * concat()方法创建并返回一个新数组，它的元素包括调用concat()的原始数组的元素和concat()的每个参数
 */
(function () {
   console.log(">>>>>>>>>>>> concat() <<<<<<<<<<<<<");
   var a = [1, 2, 3];
   a = a.concat(4, 5);
   a = a.concat([66], [88]);
   console.log(a);
   console.log("=======================");
}());

/**
 * slice()方法返回指定数组的一个片段或子数组
 */
(function () {
   console.log(">>>>>>>>>>>> slice() <<<<<<<<<<<<<");
   var a = [1, 2, 3, 4, 5];
   console.log(a.slice(1, 3));  // [2, 3]]
   console.log("=======================");
}());

/**
 * splice()方法在数组中插入或删除元素的通用方法
 */
(function () {
   console.log(">>>>>>>>>>>> splice() <<<<<<<<<<<<<");
   var a = [1,2,3,4,5,6,7,8];
   a.splice(3, 1, 'a', 'b');
   console.log(a);
   console.log("=======================");
}());

/**
 * push()：push()方法在尾部添加一个或多个元素，并返回数组新的长度
 * unshift(): 在头部插入元素
 *
 * pop()：pop()方法删除数组的最后一个元素，减小数组长度并返回它删除的值
 * shift(): 在头部取出元素
 */

/**
 * forEach()从头至尾遍历数组，为每个元素调用指定的函数。forEach()三个参数: 数组元素，元素的索引和数组本身
 */
(function () {
    console.log(">>>>>>>>>>>> forEach() <<<<<<<<<<<<<");
    var data = [1, 2, 3, 4, 5];
    var sum = 0;
    // 计算数组元素的和
    data.forEach((value) => sum += value);
    console.log(sum);
    // 为每个数组元素加1
    data.forEach((value, index, array) => array[index] = value + 1);
    console.log(data);
    console.log("=======================");
}());

/**
 * map()方法将调用的数组的每个元素传递给指定的函数，并返回一个数组
 * map()返回新数组，并不修改调用的数组
 */
(function () {
    console.log(">>>>>>>>>>>> map() <<<<<<<<<<<<<");
    var a = [1,2,3];
    var b = a.map(function(value) {return value * value;});
    console.log(a);
    console.log(b);
    console.log("=======================");
}());

/**
 * filter()方法返回的数组元素是调用的数组的一个子集
 */
(function () {
    console.log(">>>>>>>>>>>> filter() <<<<<<<<<<<<<");
    var a = [1, 2, 3, 4, 5];
    console.log(a.filter(function (t) { return t < 3 }));
    console.log(a);
    console.log("=======================");
}());

/**
 * every() 当数组中的所有元素调用判定函数都返回true时，它才返回true
 * some() 当数组中至少一个元素调用判定函数返回true时，它就返回true
 */
(function () {
console.log(">>>>>>>>>>>> every() and some() <<<<<<<<<<<<<");
var a = [1,2,3];
console.log(a.every(function (t) { return t < 4 }));
    console.log(a.every(function (t) { return t < 2 }));
console.log(a.some(function (t) { return t === 1 }));
console.log("=======================");
}());










