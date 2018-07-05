## �ַ�������
### �����ַ����ַ����ĺ������ַ������ȵĺ���
```
SELECT CHAR_LENGTH('date'), CHAR_LENGTH('egg')
SELECT LENGTH('date'), LENGTH('egg')
```

### �ϲ��ַ�������CONCAT(s1,s2,...)��CONCAT_WS(x,s1,s2,...)
```
CONCAT_WS�������Ӵ��ָ������ַ���
SELECT CONCAT_WS('-','1st','2nd')
```

### �滻�ַ����ĺ���INSERT(s1,x,len,s2)
```
INSERT(s1,x,len,s2)�����ַ���s1�������ַ�����ʼ��xλ�úͱ��ַ���s2ȡ����len�ַ�
```

### ��ĸ��Сдת������
- LOWER����LCASE ȫ��תСд
- UPPER����UCASE ȫ��ת��д

### ��ȡָ�����ȵ��ַ����ĺ���LEFT(s,n)��RIGHT(s,n)
- LEFT(s,n)�����ַ���s��ʼ�������n���ַ�
- RIGHT(s,n)�����ַ��������ұ�n���ַ�

### ����ַ����ĺ���LPAD(s1,len,s2)��RPAD(s1,len,s2)
- LPAD(s1,len,s2)�����ַ���s1����������ַ���s2���len�ַ�����
- RPAD(s1,len,s2)�����ַ���s1�����ұ߱��ַ���s2���len�ַ�����

### ɾ���ո�ĺ���LTRIM(s), RTRIM(s)��TRIN(s)
- LTRIM ɾ�����ո�
- RTRIM ɾ���Ҳ�ո�
- TRIM ɾ������ո�

### ɾ��ָ���ַ����ĺ���TRIM(s1 FROM s)
- TRIM(s1 FROM s)ɾ���ַ���s���������е����ַ���s1

### �ظ������ַ����ĺ���REPEAT(s,n)
- ����һ�����ظ����ַ���s��ɵ��ַ������ַ���s����Ŀ����n

### �ո���SPACE(n)���滻����REPLACE(s,s1,s2)
- SPACE(n)����һ����n���ո���ɵ��ַ���
- REPLACE(s,s1,s2)ʹ���ַ���s2����ַ���s�����е��ַ���s1

### �Ƚ��ַ�����С�ĺ���STRCMP(s1,s2)
- ����ͬ���򷵻�0

### ��ȡ�Ӵ��ĺ���SUBSTRING(s,n,len)��MID(s,n,len)
- SUBSTRING(s,n,len)���ַ���s����һ������ͬlen�ַ���ͬ�����ַ�������ʼ��λ��n
- MID��SUBSTRING������ͬ

### ƥ���Ӵ���ʼλ�õĺ���
- LOCATE(str1, str), POSITION(str1 IN str)��INSTR(str, str1)�������������ȹ�ͨ���������ַ���str1���ַ���str�еĿ�ʼλ��

### �ַ�������ĺ���REVERSE(s)

### ����ָ��λ�õ��ַ����ĺ���
- ELT(n, str1, str2, str3)

### ����ָ���ַ���λ�õĺ���FIELD(s, s1, s2,...)
- ����s��s1��s2��...�е�һ�γ��ֵ�λ�á�����Ҳ���s��sΪnull���򷵻�0

### �����Ӵ�λ�õĺ���FIND_IN_SET(s1,s2)
- �����ַ���s1���ַ����б�s2�г��ֵ�λ��

### ѡȡ�ַ����ĺ���MAKE_SET(x,s1,s2,...)
- MAKE_SET(x,s1,s2,...)������x�Ķ�������ָ������Ӧλ���ַ�����ɵ��ַ���

## ���ں�ʱ�亯��
### ��ȡ��ǰ���ڵĺ����ͻ�ȡ��ǰʱ��ĺ���
- CURDATE()��CURRENT_DATE()����������ͬ������ǰ���ڰ���'YYYY-MM-DD'��'YYYYMMDD'��ʽ��ֵ����

### ��ȡ��ǰ���ں�ʱ��ĺ���
- CURRENT_TIMESTAMP()��LOCALTIME(), NOW()��SYSDATE()4������������ͬ�������ص�ǰ���ں�ʱ��ֵ����ʽΪ'YYYY-MM-DD HH:MM:SS'��'YYYYMMDDHHMMSS'

### UNIXʱ�������
- UNIX_TIMESTAMP(date)������һ��UNIXʱ���
- FROM_UNIXTIME(date)������UNIXʱ���ת��Ϊ��ͨ��ʽ��ʱ�䣬��UNIX_TIMESTAMP(NOW())��Ϊ������

### ����UTC���ڵĺ����ͷ���UTCʱ��ĺ���
- UTC_DATE()���ص�ǰUTC����ֵ�����ʽΪ'YYYY-MM-DD'��YYYYMMDD
- UTC_TIME()���ص�ǰUTCʱ��ֵ�����ʽΪ'HH:MM:SS'��'HHMMSS'

### ��ȡ�·ݵĺ���MONTH(date)��MONTHNAME(date)
- MONTH(date)��������date��Ӧ���·ݣ�����ֵ��1~12
- MONTHNAME(date)������������date��Ӧ�·ݵ�Ӣ��ȫ��

### ��ȡ���ڵĺ���DAYNAME(d), DAYOFWEEK(d)��WEEKDAY(d)
- DAYNAME(d) ��ȡ��Ӧ�����յ�Ӣ������
- DAYOFWEEK(d) ����d��Ӧһ���е�������1��ʾ����
- WEEKDAY(d) �������ڶ�Ӧ������������0��ʾ��һ

### ��ȡ�������ĺ���WEED(d)��WEEKOFYEAR(d)
- WEEK(d)��������d��һ���еĵڼ���
- WEEKOFYEAR(d)����ĳ��λ��һ���еĵڼ���

### ��ȡ�����ĺ���DAYOFYEAR(d)��DAYOFMONTH(d)
- DAYOFYEAR('2016-02-20') ����һ���еĵڼ���
- DAYOFMONTH('2016-02-20') ����һ�����еĵڼ���

### ��ȡ��ݡ����ȡ�Сʱ�����Ӻ����ӵĺ���
- YEAR(date) QUARTER() MINUTE() SECOND()

### ʱ�������ת���ĺ���
- TIME_TO_SEC(time)������ת��Ϊ���time������ת����ʽΪ��Сʱ * 360 + ���� * 60 + ��
- SEC_TO_TIME(seconds) ���ر�ת��ΪСʱ�����Ӻ�������seconds����ֵ

### �������ں�ʱ��ĺ���
- DATE_ADD(date, INTERVAL expr type)��ADDDATE(date, INTERVAL expr type)��������ִ�����ڵļ�����
- DATE_SUB(date, INTERVAL expr type)��SUBDATE(date, INTERVAL expr type)ִ�����ڵļ�����
- ADDTIME(date,expr)������exprֵ��ӵ�date���������޸ĺ��ֵ
- SUBTIME(date,expr)������date��ȥexprֵ���������޸ĺ��ֵ
- DATEDIFF(date1, date2)������ʼʱ��date1�ͽ���ʱ��date2֮�������

### �����ں�ʱ���ʽ���ĺ���
- DATE_FORMAT(date, format)����formatָ���ĸ�ʽ��ʾdateֵ
- TIME_FORMAT(time,format)����format�ַ�������timeֵ�ĸ�ʽ

## �����жϺ���
### IF(expr,v1,v2)����
- ��expr��TRUE(expr<>0 and expr <> NULL)����IF()�ķ���ֵΪv1�����򷵻�ֵΪv2

### IFNULL(v1,v2)����
- ����v1��ΪNULL����IFNULL()�ķ���ֵΪv1�������䷵��ֵΪv2

### CASE������Ӱ�����ݿ����ܣ������ã�

## ϵͳ��Ϣ����
### ��ȡMYSQL�汾�ţ������������ݿ����ĺ���
- VERSION()����ָʾmysql�������汾���ַ���
- CONNECTION_ID()����mysql��������ǰ���ӵĴ���
- SHOW PROCESSLIST �����ǰ�û���������Ϣ
- DATABASE()��SCHEMA()�������ص�ǰ���ݿ���

## ��/���ܺ���
- ���ܺ���PASSWORD(str)
- ���ܺ���MD5(str)
- ���ܺ���ENCODE(str,pswd_str)
- ���ܺ���DECODE(crypt_str,pswd_str)