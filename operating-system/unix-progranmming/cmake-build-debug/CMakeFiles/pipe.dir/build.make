# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/glluenew/cq/mynote/operating-system/unix-progranmming

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/pipe.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/pipe.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/pipe.dir/flags.make

CMakeFiles/pipe.dir/ipc/pipe.c.o: CMakeFiles/pipe.dir/flags.make
CMakeFiles/pipe.dir/ipc/pipe.c.o: ../ipc/pipe.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/pipe.dir/ipc/pipe.c.o"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/pipe.dir/ipc/pipe.c.o   -c /Users/glluenew/cq/mynote/operating-system/unix-progranmming/ipc/pipe.c

CMakeFiles/pipe.dir/ipc/pipe.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/pipe.dir/ipc/pipe.c.i"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/glluenew/cq/mynote/operating-system/unix-progranmming/ipc/pipe.c > CMakeFiles/pipe.dir/ipc/pipe.c.i

CMakeFiles/pipe.dir/ipc/pipe.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/pipe.dir/ipc/pipe.c.s"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/glluenew/cq/mynote/operating-system/unix-progranmming/ipc/pipe.c -o CMakeFiles/pipe.dir/ipc/pipe.c.s

# Object files for target pipe
pipe_OBJECTS = \
"CMakeFiles/pipe.dir/ipc/pipe.c.o"

# External object files for target pipe
pipe_EXTERNAL_OBJECTS =

pipe: CMakeFiles/pipe.dir/ipc/pipe.c.o
pipe: CMakeFiles/pipe.dir/build.make
pipe: CMakeFiles/pipe.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable pipe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/pipe.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/pipe.dir/build: pipe

.PHONY : CMakeFiles/pipe.dir/build

CMakeFiles/pipe.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/pipe.dir/cmake_clean.cmake
.PHONY : CMakeFiles/pipe.dir/clean

CMakeFiles/pipe.dir/depend:
	cd /Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/glluenew/cq/mynote/operating-system/unix-progranmming /Users/glluenew/cq/mynote/operating-system/unix-progranmming /Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug /Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug /Users/glluenew/cq/mynote/operating-system/unix-progranmming/cmake-build-debug/CMakeFiles/pipe.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/pipe.dir/depend

