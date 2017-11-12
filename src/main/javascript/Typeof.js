var str = "string";
// string
console.log(typeof str);

var objectTest = {
    x: 1,
    y: 2,
    z: 3
}
// 返回一个数组，这个数组由对象中可枚举的自有属性的名称组成
console.log(Object.keys(objectTest));
// 返回对象的所有自有属性的名称，而不仅仅是可枚举的属性
console.log(Object.getOwnPropertyNames(objectTest))
for (var temp in objectTest) {
    console.log("属性名: " + temp + "属性值: " + objectTest[temp]);
}
// object
console.log(typeof objectTest);

var num = 4;
// number
console.log(typeof 4);

var bool = true;
// boolean
console.log(typeof bool);

var functionTest = function () {}
// function
console.log(typeof functionTest);

function functionTest2() {}
// function
console.log(typeof functionTest2);

// object
console.log(typeof null);

// undefined
console.log(typeof undefined);
