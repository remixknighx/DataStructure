/**
 * call()方法传递多个参数，而apply()方法传递数组
 */

/**
 * 示例一：使用call方法调用父构造函数，实现继承
 */
function Product(name, price) {
    this.name = name;
    this.price = price;
}

function Food(name, price) {
    Product.call(this, name, price);
    this.category = "food";
}

function Toy(name, price) {
    Product.call(this, name, price);
    this.category = "toy";
}

let cheese = new Food('feta', 5);
console.log(cheese.name + ": " + cheese.category);

let fun = new Toy('robot', 30);
console.log(fun.name + ": " + fun.category)

/**
 * 示例二：使用call()方法指定上下文
 */
function greet(test){
    let reply = [this.person, 'is an awesome', this.role, test].join(" ");
    console.log(reply);
}

let people = {
    person: "bill",
    role: "javascript developer"
}

greet.call(people, "fck");