package com.example.notekeeper
// A file helps in storing many simple classes together

class Course(val courseId: String, val courseTitle: String)

class NoteInfo(var course:Course, var title: String, var text: String)