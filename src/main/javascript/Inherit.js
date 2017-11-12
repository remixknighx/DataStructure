/**
 * 实现javascript中的几种继承方式
 */

/**
 * 方法一：使用prototype指向一个原型对象，实现继承
 */
function Range(from, to) {
    this.from = from;
    this.to = to;
}

var RangePrototype = {
    // 显示设置构造函数反向引用
    constructor: Range,
    includes: function (x) {
        return this.from < x && this.to >= x;
    }
};

Range.prototype = RangePrototype;

let range = new Range(3, 8);
/**
 * 若在RangePrototype不申明constructor, 则range.constructor为Object
 * 申明constructor为RangePrototype，则range.constructor为RangePrototype
 */
// console.log(range.constructor);
// console.log(RangePrototype.isPrototypeOf(range))
// console.log(range.includes(5));

/**
 * 方法二：javascript实现java式的继承
 * */
function Son(name) {
    // 实例字段
    this.name = name;
    // 实例方法
    this.sayHello = function () {
        console.log(name + " says hello");
    }
}

// 类字段
Son.prototype.FATHER = "Paul";
// 类方法
Son.prototype.whoseFather = function () {
    console.log(this.FATHER + " is " + this.name + "\'s father");
};
Son.prototype.fuck = function () {
    console.log("All fucks");
}
let bill = new Son("bill");

/**
 * 方法三：定义子类，使用extends关键字实现继承
 */
class SuperClass {
    constructor(name) {
        this.name = name;
    }

    printSuperClass() {
        console.log(this.name + " Super Class!");
    }
}

class SubClass extends SuperClass {
    constructor(name) {
        super(name);
        this.name = name;
    }

    printSubClass() {
        console.log(this.name + " Sub Class!");
    }
}

let subClass = new SubClass("wang");
subClass.printSuperClass()
subClass.printSubClass();

/**
 * 方法四：使用extend方法进行继承
 */
// TODO 未完成
// function SuperExtend(){
//     throw new Error("Cant't instantiate abstract class");
// };
// var SubExtend = SuperExtend.extend(
//     function (name) {
//         this.name = name;
//     },
//     {
//         printSubExtend:　function(){
//             console.log(this.name + " Sub Extend");
//         }
//     }
// )

/**
 * 方法五：使用Object.create()创建类式继承
 */
// Shape - superclass
function Shape() {
    this.x = 0;
    this.y = 0;
    this.move = function (x, y) {
        this.x += x;
        this.y += y;
        console.info('Shape moved.');
    }
}

// Rectangle - subclass
function Rectangle() {
    // call super constructor.
    Shape.call(this);
}

// subclass extends superclass
/**
 * Object.create()方法创建一个新对象。
 * 第一个参数是这个对象的原型，第二个参数对对象的属性进行进一步的描述
 */
Rectangle.prototype = Object.create(Shape.prototype);
Rectangle.prototype.constructor = Rectangle;

var rect = new Rectangle();
console.log('Is rect an instance of Rectangle?',
    rect instanceof Rectangle); // true
console.log('Is rect an instance of Shape?',
    rect instanceof Shape); // true
// Outputs, 'Shape moved.
rect.move(1, 1);

/**
 * 通过原型继承创建一个新对象
 * inherit()返回了一个继承自原型对象p的属性的新对象
 *
 */
function inherit(p) {
    if(p == null) throw TypeError();
    if(Object.create) {
        return Object.create(p);
    }

    var t = typeof p;
    if(t !== "object" && t !== "function") {
        throw TypeError();
    }

    function f() {}
    f.prototype = p;
    return new f();
}


