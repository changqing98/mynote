cmake_minimum_required(VERSION 3.17)
project(unix_progranmming C)

set(CMAKE_C_STANDARD 11)

include_directories(include)

#add_executable(fs fs/file.c)
#add_executable(ipc ipc/pipe.c)
#add_executable(hello hello/hello_world.c)

file(GLOB files */*.c)
foreach (file ${files})
    string(REGEX REPLACE ".+/(.+)\\..*" "\\1" exe ${file})
    add_executable(${exe} ${file} ipc/signal.cpp)
    message(\ \ \ \ --\ src/${exe}.cpp\ will\ be\ compiled\ to\ bin/${exe})
endforeach ()