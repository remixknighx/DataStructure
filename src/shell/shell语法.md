- 创建shell函数(shell函数的定义必须在其被调用的前面)
```
<!--方法一(有问题？)-->
function name{
    commands
    return
}
<!--方法二-->
name(){
    commands
    return
}
```

- 编写局部变量
```
#!/bin/bash

# global variable
foo=0

funct_1(){
    local foo
    foo=1
    echo "funct_1: foo = $foo"
}


funct_2(){
    local foo
    foo=2
    echo "funct_2: foo = $foo"
}

echo "global: foo = $foo"
funct_1
echo "global: foo = $foo"
funct_2
echo "global: foo = $foo"
```

- IF分支语句
```
#!/bin/bash

x=4

if [ $x = 5 ]; then
       echo "x equals 5"
elif [ $x = 4 ]; then
       echo "x equals 4"
else
       echo "x does not equal 5 or 4"
fi
```

- 文件表达式
```
-d file file存在并且是一个目录
-e file file存在
-f file file存在并且是一个普通文件
-L file file存在并且是一个符号链接
-r file file存在并且可读
-w file file存在并且可写
-x file file存在并且可执行
```

- 字符串表达式
```
string string不为空
-n string string的长度大于0
-z string string的长度等于0
string1==string2 string1等于string2
string1!=string2 string1 string2不相等

<!--demo-->
#!/bin/bash

ANSWER=maybe

if [ -z "$ANSWER" ]; then
        echo "There is no answer" >&2
        exit 1
fi
if [ "$ANSWER" = "yes" ]; then
        echo "The answer is yes"
elif [ "$ANSWER" = "no" ]; then
        echo "The answer is no"
elif [ "$ANSWER" = "maybe" ]; then
        echo "The answer is maybe"
else
        echo "The answer is UNKNOWN"
fi
```

- 整数表达式
```
integer! -eq integer2 相等
integer1 -ne integer2 不相等
-le 小于等于
-lt 小于
-ge 大于等于
-gt 大于
```

- 跟现代的test命令[[]]
```
<!--string1与扩展的正则表达式regex匹配-->
[[ string1=~regex ]]

支持模式匹配
```

- 组合表达式
```
Operation | test | [[]] and (())
---|---|---
AND | -a | &&
OR | -o | ||
NOT | ! | !
```

- read：从标准输入读取输入值(read [-options] [variable])
    - options选项
        - -a array: 将输入值从索引为0的位置开始赋给array
        - -d delimiter: 用字符串delimiter的第一个字符标志输入的结束,而不是新的一行的开始
        - -c: 使用readLine处理输入
        - -n num: 从输入中读取num个字符,而不是一整行
        - -p prompt：使用prompt字符串提示用户进行输入
        - -r：原始模式。不能将后斜线字符翻译为转义码
        - -s：保密模式。不在屏幕显示输入的字符。此模式在输入密码和其他机密信息时很有用处
        - -t seconds：超时。在seconds秒后结束输入。若输入超时，read命令返回一个非0的退出状态
        - -u fd：从文件说明符fd读取输入，而不是从标准输入中读取
```
<!--输入一个参数-->
#!/bin/bash

echo -n "Please enter an integer -> "
read int

if [ $int -eq 0 ]; then
        echo "$int is 0"
else
        if [ $int -lt 0 ]; then
                echo "$int is negative"
        else
                echo "$int is positive"
        fi
        if [ $((int % 2)) -eq 0 ]; then
                echo "$int is even."
        else
                echo "$int is odd"
        fi
fi

<!--输入多个参数-->
#!/bin/bash

# read-multiple
echo -n "Enter one or more values > "
read var1 var2 var3 var4 var5

echo "var1 = $var1"
echo "var2 = $var2"
echo "var3 = $var3"
echo "var4 = $var4"
echo "var5 = $var5"

<!--菜单输入-->
#!/bin/bash

clear
echo "
Please select

1. Display System Information
2. Display Disk Space
3. Display Home Space Utilization
0. Quit"

echo -n "Enter selection [0~3] > "
read num

if [ $num = 0 ]; then
    echo "Program terminated"
    exit
fi
if [ $num = 1 ]; then
    echo "Hostname: $HOSTNAME"
    uptime
    exit
fi
if [ $num = 2 ]; then
    df -h
    exit
fi
if [ $num = 3 ]; then
        if [ $(id -u) -eq 0 ]; then
                echo "Home Space Utilization(All Users)"
                du -sh /home/*
        else
                echo "Home Space Utilization($USER)"
                du -sh $HOME
        fi
        exit
fi
```

- while
```
#!/bin/bash

count=1

while [ $count -le 5 ]; do
        echo $count
        count=$((count + 1))
done
echo "Finished"
```