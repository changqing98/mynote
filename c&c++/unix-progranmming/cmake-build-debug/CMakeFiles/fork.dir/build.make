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
CMAKE_SOURCE_DIR = "/Users/changqing/workspace/mynote/c&c++/unix-progranmming"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/fork.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/fork.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/fork.dir/flags.make

CMakeFiles/fork.dir/proc/fork.c.o: CMakeFiles/fork.dir/flags.make
CMakeFiles/fork.dir/proc/fork.c.o: ../proc/fork.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/fork.dir/proc/fork.c.o"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/fork.dir/proc/fork.c.o   -c "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/proc/fork.c"

CMakeFiles/fork.dir/proc/fork.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/fork.dir/proc/fork.c.i"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/proc/fork.c" > CMakeFiles/fork.dir/proc/fork.c.i

CMakeFiles/fork.dir/proc/fork.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/fork.dir/proc/fork.c.s"
	/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/proc/fork.c" -o CMakeFiles/fork.dir/proc/fork.c.s

# Object files for target fork
fork_OBJECTS = \
"CMakeFiles/fork.dir/proc/fork.c.o"

# External object files for target fork
fork_EXTERNAL_OBJECTS =

fork: CMakeFiles/fork.dir/proc/fork.c.o
fork: CMakeFiles/fork.dir/build.make
fork: CMakeFiles/fork.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable fork"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/fork.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/fork.dir/build: fork

.PHONY : CMakeFiles/fork.dir/build

CMakeFiles/fork.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/fork.dir/cmake_clean.cmake
.PHONY : CMakeFiles/fork.dir/clean

CMakeFiles/fork.dir/depend:
	cd "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/Users/changqing/workspace/mynote/c&c++/unix-progranmming" "/Users/changqing/workspace/mynote/c&c++/unix-progranmming" "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug" "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug" "/Users/changqing/workspace/mynote/c&c++/unix-progranmming/cmake-build-debug/CMakeFiles/fork.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/fork.dir/depend

