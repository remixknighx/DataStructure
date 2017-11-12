/**
 * 无参数的箭头函数
 */
var arrowOne = ()=> console.log("无参函数");
arrowOne();

/**
 * 有参数的箭头函数
 */
var arrowTwo = (paramA, paramB)=> console.log("有参数的函数，参数为: " + paramA + "和" + paramB);
arrowTwo("arrowTwoA", "arrowTwoB");
