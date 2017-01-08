目的 : 
```
根据网易云课堂上的课程 : 
[Linux kernel Hacker, 从零构建自己的内核](http://study.163.com/course/courseMain.htm?courseId=1003169025)
[汇编语言从 0 开始](http://study.163.com/course/courseMain.htm?courseId=1640004)
动手实践 , 跟着老师一步一步走 , 尝试实现简单的操作系统
```
环境搭建 : 
```
=======================
物理机需要安装 Virtual Box 虚拟机软件(因为需要将我们写好的操作系统运行起来 , 使用其他的虚拟机软件同样都可以达到要求)
=======================
[Virtual Box](https://www.virtualbox.org/)
=======================
Ubuntu 虚拟机
=======================
1. 编辑器 : vim
sudo apt-get install vim
2. c语言开发环境 : 
sudo apt-get install build-essential
3. java开发环境
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
sudo apt-get install oracle-java8-set-default
4. 汇编语言开发环境(从这里获取最新的下载地址 : http://www.nasm.us/)
wget http://www.nasm.us/pub/nasm/releasebuilds/2.12.02/nasm-2.12.02.tar.xz
xz -d nasm-2.12.02.tar.xz
tar -xf nasm-2.12.02.tar
cd nasm-2.12.02
./configure
make
sudo make install
======================
(
突然发现汇编代码在Windows下编译并不能符合要求
因此需要我们在类Unix环境下使用 nasm 进行编译
因此舍弃下面的部分
)
~~Windows XP 虚拟机~~
======================
4. 汇编开发环境
在项目根目录下 /resource/masm 文件夹中 , 将其复制到 XP 虚拟机中即可
还需要一个DEBUG工具用于我们反编译和调试汇编程序 , 这个工具是 XP 自带的
```
