/**
 * 1. 普通promise用法
 *
 * @param num
 * @returns {Promise}
 * @constructor
 */
function NumPromise(num) {
    return new Promise(function (resolve, reject) {
        if(num > 5) {
            resolve("大于5");
        } else {
            reject("小于等于5");
        }
    })
}

NumPromise(3).then(function (result) {
    console.log(result);
}).catch(function (result) {
    console.log(result);
});

/**
 * 2. 调用then的返回值
 */
Promise.resolve(6)
    .then(function (val) {
        console.log(val);
        throw new Error("ERROR");
        return val + 1;
    }).then(function (val) {
        console.log(val);
        return val * 2;
    }).then(function (val) {
        console.log("final result: " + val);
}).catch(function (error) {
        console.log(error);
})

/**
 * 3. Promise.all用法
 */
// `delay`毫秒后执行resolve
function timerPromisefy(delay) {
    return new Promise(function (resolve) {
        setTimeout(function () {
            resolve(delay);
        }, delay);
    });
}

function errorTimerPromisefy(delay) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            reject(delay);
        }, delay);
    });
}
var startDate = Date.now();
// TODO 重点：所有promise变为resolve后程序退出
Promise.all([
    timerPromisefy(6),
    timerPromisefy(32),
    timerPromisefy(64),
    timerPromisefy(128),
    errorTimerPromisefy(1000)
]).then(function (values) {
    console.log(Date.now() - startDate + 'ms');
    // 約128ms
    console.log(values);// [1,32,64,128]
}).catch(function (error) {
    console.error("error: " + error);
});

/**
 * 4. Promise.race用法
 */
// `delay`毫秒后执行resolve
function timerPromisefy(delay) {
    return new Promise(function (resolve) {
        setTimeout(function () {
            resolve(delay);
        }, delay);
    });
}

function errorTimerPromisefy(delay) {
    return new Promise(function (resolve, reject) {
        setTimeout(function () {
            reject(delay);
        }, delay);
    });
}
// 任何一个promise变为resolve或reject 的话程序就停止运行
Promise.race([
    timerPromisefy(5),
    timerPromisefy(32),
    timerPromisefy(64),
    timerPromisefy(128),
    errorTimerPromisefy(2)
]).then(function (value) {
    console.log(value);    // => 1
}).catch(function (error) {
    console.log(error)
});






