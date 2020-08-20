# Shell

## Shell简介

Shell是Unix系统下的终端命令解释器，发明者是Steven Bourne，Shell本身是壳的意思，表示最外层，表明了早期用户都需要通过Shell与Kernel内核交互。后来Unix后衍生出了多个操作系统，例如Linux，Linux下面的终端命令解释器是Bash，据说是Linux的相关开发人员又找了当年Shell的设计者Steven Bourne，请他为Linux开发一款终端命令解释器，于是起名为Bash（Bourne Again Shell）。

简而言之，可以认为当今我们使用的主流Linux操作系统所支持的sh、bash、zsh等都是Shell，只是版本不同、命名不同，其对应的功能也不同。

为了统一称呼，我们接下来所说的Shell通常（除了有特殊说明的地方）就是指我们主流Linux操作系统下的Bash。

## Shell基本操作

### 查看系统支持的Shell

```bash
➜ cat /etc/shells

/bin/bash
/bin/csh
/bin/dash
/bin/ksh
/bin/sh
/bin/tcsh
/bin/zsh
```

### 查看系统当前使用的Shell

```bash
➜ echo $SHELL
/bin/zsh
```

### 更换登录系统时使用的Shell

例如将系统Shell更换为zsh

```bash
chsh -s /bin/zsh
```

