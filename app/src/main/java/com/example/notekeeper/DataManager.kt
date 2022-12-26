package com.example.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    /*
                init block
        - Doesn't accept parameters since it cannot be initialised
        - can access the primary constructor properties of a class
        - called when the class/object is initialised
     */

    init {
        initializeCourses()
    }

    private fun initializeCourses(){

        val course = CourseInfo("java_core", "Java Fundamentals: The core Platform")
        val course1 = CourseInfo("java_lang", "Java Fundamentals: Java programming language")
        val course2 = CourseInfo("android_async", "Async programming with services")
        val course3 = CourseInfo("intents", "Passing data and starting activities using intents")
        courses[course.courseId] = course
        courses[course1.courseId] = course1
        courses[course2.courseId] = course2
        courses[course3.courseId] = course3
    }

}