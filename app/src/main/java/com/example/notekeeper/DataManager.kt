package com.example.notekeeper

class DataManager {
    private val courses = HashMap<String, Course>()
    val notes = ArrayList<NoteInfo>()

    private fun initializeCourses(){
        val course = Course("android_intents", "Passing data using intents")
        courses[course.courseId] = course
        val course1 = Course("java_core", "Java programming fundamentals: The core Platform")
        courses[course1.courseId] = course1
        val course2 = Course("android_async", "Android async programming with services")
        courses[course2.courseId] = course2
        val course3 = Course("java_lang","Java programming Fundamentals: The java Language")
        courses[course3.courseId] = course3
    }
}