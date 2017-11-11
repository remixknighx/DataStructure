/*
* 匿名函数最大的用途是创建闭包（这是JavaScript语言的特性之一），并且还可以构建命名空间，以减少全局变量的使用。
* */
/**
 * 第一种匿名函数方式
 */
!function (test) {
    console.log(test);
}("test1")

/**
 * 第二种匿名函数方式
 */
(function (test) {
    console.log(test);
}("test2"))

/**
 * 第三种匿名函数方式
 */
(function (test) {
    console.log(test);
})("test3")