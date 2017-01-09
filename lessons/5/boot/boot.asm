org 7C00H

LOAD_ADDRESS EQU 8000H

; 初始化(清空寄存器)
init:
    mov ax, 0
    mov ds, ax
    mov ss, ax
    mov es, ax
	mov si, ax

; 读取指定扇区的内容 , 并将内容加载进内存
read:
	mov al, 01H ; 读取的扇区数 (读取一个扇区)
	mov ch, 01H ; 柱面
	mov cl, 02H	; 扇区 (扇区从 1 开始)
	mov dh, 00H ; 磁头
	mov dl, 00H ; 默认一个软盘 (编号为 0)

	mov bx, LOAD_ADDRESS ; 用 msg 作为读取数据返回值的缓冲区

	mov ah, 02H ; 调用 BIOS中断
	int 13H;

	jc error ; CF 标志位为 0 的时候读取成功 , 否则需要错误处理
	jmp LOAD_ADDRESS ; 已经将内核成功加载进内存 , 现在将计算机的控制权交给系统内核

error: ; 读盘错误处理
	HLT
	jmp error
