cmake_minimum_required(VERSION 3.30)
project(jv_contest)

option(USE_TASK_1 "Build Task 1" OFF)
option(USE_TASK_2 "Build Task 2" ON)

if(USE_TASK_1 AND USE_TASK_2)
    message(FATAL_ERROR "Only one task can be enabled at a time.")
elseif(USE_TASK_1)
    set(SOURCES src/task_1.cpp)
elseif(USE_TASK_2)
    set(SOURCES src/task_2.cpp)
else()
    message(FATAL_ERROR "No task selected. Please enable one task option.")
endif()

add_executable(test ${SOURCES})
