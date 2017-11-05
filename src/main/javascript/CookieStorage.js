/**
 * ## cookie进行存储
 * - 有效期：只持续在web浏览器的会话期间，同浏览器的进程相关而不是单个浏览器窗口的有效期。可以通过设置**max-age**属性延长cookie的有效期。
 * - 作用域：通过**文档源**和**文档路径**确定。**domain**设置文档源 **path**设置cookie路径
 *
 * @param maxage 有效期
 * @param path 作用域
 * @constructor
 */
function CookieStorage(maxage, path){
    // 从浏览器中获取之前保存的cookie值
    var cookie = (function () {
        let cookie = {};
        let all = document.cookie;
        if(all === ""){
            return cookie;
        }
        let list = all.split("; ");
        for(let i = 0; i < list.length; i++){
            let singleCookie = list[i];
            let p = singleCookie.indexOf("=");
            let name = singleCookie.substring(0, p);
            let value = singleCookie.substring(p+1);
            value = decodeURIComponent(value);
            cookie[name] = value;
        }
        return cookie;
    }());

    // 根据name从cookie中获取指定的value值
    this.getItem = function (name) {
        return cookie[name] || null;
    }

    // 存储cookie值
    this.setItem = function(name, value) {
        // 保存到cookie对象中
        cookie[name] = value;

        let newCookie = name + "=" + encodeURIComponent(value);
        if(maxage) {
            newCookie += "; max-age=" + maxage;
        }
        if(path) {
            newCookie += "; path=" + path;
        }
        document.cookie = newCookie;
    }

    // 删除指定的cooie值
    this.removeItem = function (name) {
        // 若该cookie不存在，则直接返回
        if(!(name in cookie)){
            return;
        }

        delete cookie[name];

        // 通过将cookie值设置为空字符串以及将有效期设置为0来删除指定的cookie
        document.cookie = name + "=; max-age=0";
    }

}












