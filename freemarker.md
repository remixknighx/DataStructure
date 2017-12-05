## ȡֵ����
- ����${var}�﷨����ȡֵ
- ��null�������ڶ���ȡֵ${var!'DefaultValue'}
- ȡ��װ�����ֵ��ͨ��"��"�﷨: ${User.name}
- Date���͸�ʽ${date?String('yyyy-MM-dd')} (���java.util.Date)
- ���ת��html���ݣ�${var?html}

## ��ֵ
```
<#assign a=100/>
    a = <font> ${a} </font><br/>
```

## ����List����
```
<#list myList as item>
    <font>${item!}</font>
</#list>
```

## ����Map����
```
<#list map?keys as key>
    <font>${key}:${map[key]}</font><br/>
</#list>
```

## if�﷨
```
<#assign var=99/>
    <#if var &gt; 99>
        <font>var ���� 99</font>
    <#elseif var == 99>
        <font>var = 99</font>    
    <#else>
        <font>var С�� 99</font>    
    </#if>
    
-- ??: �ж�myList�����Ƿ����    
<#if myList??>
<#list myList as item>
    ${item}
</#list>
</if>

-- if������ || && !
<#assign var = 'python' || var == 'java'>
<#if var == 'python' || var == 'java'>
    <font>python or java</font></br>
</#if>

<#if var == 'python' && var?length == 6>
    <font>python length is 6</font></br>
</#if>
```

## switch�﷨
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

## freemarker�����ַ����ڽ�����
```
<#assign a = 'hello'/>
<#assign b = 'world'/>

-- ƴ��
<font>${a + b}</font>

-- ��ȡ
<font>${(a + b)?substring(5,8)}</font>

-- ����
<font>${(a + b)?length}</font>

-- ��д
<font>${(a + b)?upper_case}</font>

-- Сд
<font>${(a + b)?lower_case}</font>

-- index_of
<font>${(a + b)?index_of('w')}</font>

-- replace
<font>${(a + b)?replace('o', 'xx')}</font>

-- last_index_of
<font>${(a + b)?last_index_of('w')}</font>
```

## freemarker�Զ��庯��
```
-- ������
<#assign myList=[1,2,3,4,5,8,7,6,9]/>
<#list sort_int(myList) as item>
    ${item}
</#list>
```

## list����ָ��
```
-- ����sort������item_index��ʾ�Զ����±�
<#assign myList=[3,5,7,4]/>
    <#list myList?sort?reverse as item>
        ${item_index}: ${item}<br>
        ${myList?size}<br>
        ${myList[3]}
    </#list>
</#assign>
```

## �Զ���ָ��
- ��@��ͷ����<@role></@role>

## �����ַ������ڽ�����
```
substring, cap_first, end_with, contains, date, datetime, time, starts_with, index_of, last_index_of, split, trim
```

## �������ֵ��ڽ�����
```
string, x.string("0.##"), round, floor, ceiling, 
```

## ����list���ڽ�����
```
first, last, seq_contains, seq_index_of, size, reverse, sort, sort_by, chunk
```

## �ַ���ת����
```
<#assign var1="01/03/2017"?date("MM/dd/yyyy")>
<#assign var2="15:05:30"?time("HH:mm:ss")>
<#assign var3="2016-12-31 03:06 PM"?datetime("yyyy-MM-dd hh:mm")>
```

## �����ڽ�����
```
<#assign sVar='hello'/>
${sVar?is_number?string('yes', 'no')}
${sVar?has_content?string('yes', 'no')}
```

## ��macro, nested, returnָ��
```
<#macro macro name param1 param2 param3 paramN>
    template_code ${param1}
    <#nested/>
</#macro>

����
<@macro_name param1="value1" param2="value2">
    nested_template
</@macro_name>
``` 

## ����function, returnָ��
```
<#function function_name param1 param2>
    <#return param1 + param2>
</#function>

����
${function_name(100, 199)}
```











