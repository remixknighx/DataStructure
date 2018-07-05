## 字符串函数
### 计算字符串字符数的函数和字符串长度的函数
```
SELECT CHAR_LENGTH('date'), CHAR_LENGTH('egg')
SELECT LENGTH('date'), LENGTH('egg')
```

### 合并字符串函数CONCAT(s1,s2,...)、CONCAT_WS(x,s1,s2,...)
```
CONCAT_WS函数连接带分隔符的字符串
SELECT CONCAT_WS('-','1st','2nd')
```

### 替换字符串的函数INSERT(s1,x,len,s2)
```
INSERT(s1,x,len,s2)返回字符串s1，其子字符串起始于x位置和被字符串s2取代的len字符
```

### 字母大小写转换函数
- LOWER或者LCASE 全部转小写
- UPPER或者UCASE 全部转大写

### 获取指定长度的字符串的函数LEFT(s,n)和RIGHT(s,n)
- LEFT(s,n)返回字符串s开始的最左边n个字符
- RIGHT(s,n)返回字符串中最右边n个字符

### 填充字符串的函数LPAD(s1,len,s2)和RPAD(s1,len,s2)
- LPAD(s1,len,s2)返回字符串s1，其左边由字符串s2填补到len字符长度
- RPAD(s1,len,s2)返回字符串s1，其右边被字符串s2填补到len字符长度

### 删除空格的函数LTRIM(s), RTRIM(s)和TRIN(s)
- LTRIM 删除左侧空格
- RTRIM 删除右侧空格
- TRIM 删除两侧空格

### 删除指定字符串的函数TRIM(s1 FROM s)
- TRIM(s1 FROM s)删除字符串s中两端所有的子字符串s1

### 重复生成字符串的函数REPEAT(s,n)
- 返回一个由重复的字符串s组成的字符串，字符串s的数目等于n

### 空格函数SPACE(n)和替换函数REPLACE(s,s1,s2)
- SPACE(n)返回一个由n个空格组成的字符串
- REPLACE(s,s1,s2)使用字符串s2替代字符串s中所有的字符串s1

### 比较字符串大小的函数STRCMP(s1,s2)
- 均相同，则返回0

### 获取子串的函数SUBSTRING(s,n,len)和MID(s,n,len)
- SUBSTRING(s,n,len)从字符串s返回一个长度同len字符相同的子字符串，起始于位置n
- MID与SUBSTRING作用相同

### 匹配子串开始位置的函数
- LOCATE(str1, str), POSITION(str1 IN str)和INSTR(str, str1)三个函数作用先沟通，返回子字符串str1在字符串str中的开始位置

### 字符串逆序的函数REVERSE(s)

### 返回指定位置的字符串的函数
- ELT(n, str1, str2, str3)

### 返回指定字符串位置的函数FIELD(s, s1, s2,...)
- 返回s在s1，s2，...中第一次出现的位置。如果找不到s或s为null，则返回0

### 返回子串位置的函数FIND_IN_SET(s1,s2)
- 返回字符串s1在字符串列表s2中出现的位置

### 选取字符串的函数MAKE_SET(x,s1,s2,...)
- MAKE_SET(x,s1,s2,...)返回由x的二进制数指定的相应位的字符串组成的字符串

## 日期和时间函数
### 获取当前日期的函数和获取当前时间的函数
- CURDATE()和CURRENT_DATE()函数作用相同，将当前日期按照'YYYY-MM-DD'或'YYYYMMDD'格式的值返回

### 获取当前日期和时间的函数
- CURRENT_TIMESTAMP()，LOCALTIME(), NOW()和SYSDATE()4个函数作用相同，均返回当前日期和时间值，格式为'YYYY-MM-DD HH:MM:SS'或'YYYYMMDDHHMMSS'

### UNIX时间戳函数
- UNIX_TIMESTAMP(date)，返回一个UNIX时间戳
- FROM_UNIXTIME(date)函数把UNIX时间戳转换为普通格式的时间，与UNIX_TIMESTAMP(NOW())互为反函数

### 返回UTC日期的函数和返回UTC时间的函数
- UTC_DATE()返回当前UTC日期值，其格式为'YYYY-MM-DD'或YYYYMMDD
- UTC_TIME()返回当前UTC时间值，其格式为'HH:MM:SS'或'HHMMSS'

### 获取月份的函数MONTH(date)和MONTHNAME(date)
- MONTH(date)函数返回date对应的月份，返回值从1~12
- MONTHNAME(date)函数返回日期date对应月份的英文全名

### 获取星期的函数DAYNAME(d), DAYOFWEEK(d)和WEEKDAY(d)
- DAYNAME(d) 获取对应工作日的英文名称
- DAYOFWEEK(d) 返回d对应一周中的索引，1表示周日
- WEEKDAY(d) 返回日期对应工作日索引，0表示周一

### 获取星期数的函数WEED(d)和WEEKOFYEAR(d)
- WEEK(d)计算日期d是一年中的第几周
- WEEKOFYEAR(d)计算某天位于一年中的第几周

### 获取天数的函数DAYOFYEAR(d)和DAYOFMONTH(d)
- DAYOFYEAR('2016-02-20') 返回一年中的第几天
- DAYOFMONTH('2016-02-20') 返回一个月中的第几天

### 获取年份、季度、小时、分钟和秒钟的函数
- YEAR(date) QUARTER() MINUTE() SECOND()

### 时间和秒钟转换的函数
- TIME_TO_SEC(time)返回已转化为秒的time参数。转换公式为：小时 * 360 + 分钟 * 60 + 秒
- SEC_TO_TIME(seconds) 返回被转化为小时、分钟和秒数的seconds参数值

### 计算日期和时间的函数
- DATE_ADD(date, INTERVAL expr type)和ADDDATE(date, INTERVAL expr type)两个函数执行日期的加运算
- DATE_SUB(date, INTERVAL expr type)和SUBDATE(date, INTERVAL expr type)执行日期的减运算
- ADDTIME(date,expr)函数将expr值添加到date，并返回修改后的值
- SUBTIME(date,expr)函数中date减去expr值，并返回修改后的值
- DATEDIFF(date1, date2)返回起始时间date1和结束时间date2之间的天数

### 将日期和时间格式化的函数
- DATE_FORMAT(date, format)根据format指定的格式显示date值
- TIME_FORMAT(time,format)根据format字符串安排time值的格式

## 条件判断函数
### IF(expr,v1,v2)函数
- 若expr是TRUE(expr<>0 and expr <> NULL)，则IF()的返回值为v1；否则返回值为v2

### IFNULL(v1,v2)函数
- 假如v1不为NULL，则IFNULL()的返回值为v1；否则其返回值为v2

### CASE函数（影响数据库性能，不常用）

## 系统信息函数
### 获取MYSQL版本号，连接数和数据库名的函数
- VERSION()返回指示mysql服务器版本的字符串
- CONNECTION_ID()返回mysql服务器当前连接的次数
- SHOW PROCESSLIST 输出当前用户的连接信息
- DATABASE()和SCHEMA()函数返回当前数据库名

## 加/解密函数
- 加密函数PASSWORD(str)
- 加密函数MD5(str)
- 加密函数ENCODE(str,pswd_str)
- 解密函数DECODE(crypt_str,pswd_str)