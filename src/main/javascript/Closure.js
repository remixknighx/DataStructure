/**
 * 闭包：闭包就是能够读取其他函数内部变量的函数
 *
 * 由于在Javascript语言中，只有函数内部的子函数才能读取局部变量，
 * 因此可以把闭包简单理解成"定义在一个函数内部的函数"。
 * 
 * 闭包的用处
 * 1. 读取函数内部的变量
 * 2. 让这些变量的值始终保持在内存中
 *
 * 闭包的特点
 * 1. 闭包是一个函数
 * 2. 闭包可以使用在它外面定义的变量
 * 3. 闭包存在定义该变量的作用域中
 *
 * @link http://www.ruanyifeng.com/blog/2009/08/learning_javascript_closures.html
 */

/**
 * 1. 读取函数内部的变量
 */
function f1() {
    let n = 3;

    function f2() {
       console.log(n)
    }

    return f2();
}

f1();

/**
 * 2. 使用闭包模拟私有方法
 */
var makeCounter = function() {
    var privateCounter = 0;
    function changeBy(val) {
        privateCounter += val;
    }
    return {
        increment: function() {
            changeBy(1);
        },
        decrement: function() {
            changeBy(-1);
        },
        value: function() {
            return privateCounter;
        }
    }
};

var Counter1 = makeCounter();
var Counter2 = makeCounter();
console.log(Counter1.value()); /* logs 0 */
Counter1.increment();
Counter1.increment();
console.log(Counter1.value()); /* logs 2 */
Counter1.decrement();
console.log(Counter1.value()); /* logs 1 */
console.log(Counter2.value()); /* logs 0 */










