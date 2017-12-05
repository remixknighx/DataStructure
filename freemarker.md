## 取值命令
- 常用${var}语法进行取值
- 对null、不存在对象取值${var!'DefaultValue'}
- 取包装对象的值，通过"点"语法: ${User.name}
- Date类型格式${date?String('yyyy-MM-dd')} (针对java.util.Date)
- 如何转义html内容：${var?html}

## 赋值
```
<#assign a=100/>
    a = <font> ${a} </font><br/>
```

## 遍历List集合
```
<#list myList as item>
    <font>${item!}</font>
</#list>
```

## 遍历Map集合
```
<#list map?keys as key>
    <font>${key}:${map[key]}</font><br/>
</#list>
```

## if语法
```
<#assign var=99/>
    <#if var &gt; 99>
        <font>var 大于 99</font>
    <#elseif var == 99>
        <font>var = 99</font>    
    <#else>
        <font>var 小于 99</font>    
    </#if>
    
-- ??: 判断myList对象是否存在    
<#if myList??>
<#list myList as item>
    ${item}
</#list>
</if>

-- if多条件 || && !
<#assign var = 'python' || var == 'java'>
<#if var == 'python' || var == 'java'>
    <font>python or java</font></br>
</#if>

<#if var == 'python' && var?length == 6>
    <font>python length is 6</font></br>
</#if>
```

## switch语法
```
<#assign var = 10/>
<#switch var>
    <#case 10>
        10<br>
    <#break>
    <#case 100>
        100<br>
    <#break>
    <#default>
        other
    <#break>
</#switch>
```

## freemarker常用字符串内建函数
```
<#assign a = 'hello'/>
<#assign b = 'world'/>

-- 拼接
<font>${a + b}</font>

-- 截取
<font>${(a + b)?substring(5,8)}</font>

-- 长度
<font>${(a + b)?length}</font>

-- 大写
<font>${(a + b)?upper_case}</font>

-- 小写
<font>${(a + b)?lower_case}</font>

-- index_of
<font>${(a + b)?index_of('w')}</font>

-- replace
<font>${(a + b)?replace('o', 'xx')}</font>

-- last_index_of
<font>${(a + b)?last_index_of('w')}</font>
```

## freemarker自定义函数
```
-- 已排序
<#assign myList=[1,2,3,4,5,8,7,6,9]/>
<#list sort_int(myList) as item>
    ${item}
</#list>
```

## list常用指令
```
-- 调用sort方法，item_index显示自定义下标
<#assign myList=[3,5,7,4]/>
    <#list myList?sort?reverse as item>
        ${item_index}: ${item}<br>
        ${myList?size}<br>
        ${myList[3]}
    </#list>
</#assign>
```

## 自定义指令
- 以@开头，如<@role></@role>

## 处理字符串的内建函数
```
substring, cap_first, end_with, contains, date, datetime, time, starts_with, index_of, last_index_of, split, trim
```

## 处理数字的内建函数
```
string, x.string("0.##"), round, floor, ceiling, 
```

## 处理list的内建函数
```
first, last, seq_contains, seq_index_of, size, reverse, sort, sort_by, chunk
```

## 字符串转日期
```
<#assign var1="01/03/2017"?date("MM/dd/yyyy")>
<#assign var2="15:05:30"?time("HH:mm:ss")>
<#assign var3="2016-12-31 03:06 PM"?datetime("yyyy-MM-dd hh:mm")>
```

## 其他内建函数
```
<#assign sVar='hello'/>
${sVar?is_number?string('yes', 'no')}
${sVar?has_content?string('yes', 'no')}
```

## 宏macro, nested, return指令
```
<#macro macro name param1 param2 param3 paramN>
    template_code ${param1}
    <#nested/>
</#macro>

调用
<@macro_name param1="value1" param2="value2">
    nested_template
</@macro_name>
``` 

## 函数function, return指令
```
<#function function_name param1 param2>
    <#return param1 + param2>
</#function>

调用
${function_name(100, 199)}
```











