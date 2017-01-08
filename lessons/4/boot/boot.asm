org 7C00H

; 初始化(清空寄存器)
init:
    mov ax, 0
    mov ds, ax
    mov ss, ax
    mov es, ax
	mov si, msg ; 将 si 置为 msg 的地址 , 也就是指向了 "Hello World!" 的首地址 , 也就是字符 'H' 的 ASCII 的值的二进制代码

read:
	mov al, 01H ; 读取的扇区数 (读取一个扇区)
	mov ch, 00H ; 柱面
	mov cl, 02H	; 扇区 (扇区从 1 开始)
	mov dh, 00H ; 磁头
	mov dl, 00H ; 默认一个软盘 (编号为 0)

	mov bx, msg ; 用 msg 作为读取数据返回值的缓冲区

	mov ah, 02H ; 调用 BIOS中断
	int 13H;

	jc error ; CF 标志位为 0 的时候读取成功 , 否则需要错误处理

; 循环输出每一个字符
myloop:
    mov al, [si] ; 将字符串的一个字符移动到 al 寄存器中 , 以用于后面的 BIOS 中断调用
    add si, 1 ; 寄存器加一 , 即下次输出下一个字符
    cmp al, 0 ; 判断字符串是否结束
    je finish ; 如果结束则跳出循环
    mov ah, 0EH ; 调用 BIOS 中断 , 该中断的功能即为 "在Teletype模式下显示字符" , 中断详情可以查询 : resource/pdf/BIOS中断大全.pdf
    mov bh, 00H ; 在这个中断中 , bh 表示页码 , 设置为 0 即可
    ; mov bl 15H ; 在这个中断中 , bl 表示颜色 , 而 15 指的是白色
    int 10H ; 调用 BIOS 中断 , 0x10H 中断指的是 "显示服务"
    jmp myloop

; 让硬件死循环进入休眠状态
finish:
    HLT
    jmp finish

error: ; 读盘错误处理
	mov si, errmsg
	jmp myloop

msg:
	RESB 64 ; RESB指令是“reserve byte”的略写预约字节 , 这里存放读取到的数据 , 这个地方编译的时候会报 Warning : uninitialized space declared in .text section: zeroing , 暂时不知道什么意思 , 不过应该不影响

errmsg:
	db "Read error!"
	db 0

