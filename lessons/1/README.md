说明 : 
```
HelloWorld.java 利用了Java的某些库来构建一个 img 格式的镜像文件
代码中硬编码了一些二进制代码 , 这些代码是使用汇编语言构建的二进制代码
在第二节课中会详细介绍 , 现在只需要对其有一个感性的认识 , 先将一个HelloWorld的操作系统跑起来
```
步骤 : 
```
1. 编译生成 HelloWorld.class 字节码
javac HelloWorld.java
2. 运行Java程序构建 img 镜像文件
java HelloWorld
3. 创建一个虚拟机并装载这个镜像文件
```
