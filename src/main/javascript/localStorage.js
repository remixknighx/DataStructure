/**
 * ## 使用localStorage进行存储
 * - 有效期：永久性。除非web应用刻意删除存储的数据
 * - 作用域：限定在**文档源**级别。文档源通过协议、主机名和端口三者来确定。同源文档间共享同样的localStorage数据。不同标签页共享localStorage
 */
localStorage.setItem("x", 1);
localStorage.getItem("x");
localStorage.removeItem("x");
localStorage.clear();

/**
 * ## 使用sessionStorage进行存储
 * - 有效期：同最顶层的窗口或者是浏览器标签页是一样的，一旦窗口或者标签页被永久关闭，sessionStorage存储的数据也都被删除了。
 * - 作用域：限定在文档源中。不同标签页的sessionStorage不同
 */
sessionStorage.setItem("x", 1);
sessionStorage.getItem("x");
sessionStorage.removeItem("x");
sessionStorage.clear();