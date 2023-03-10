package com.example.notekeeper

data class CourseInfo(val courseId:String, val courseTitle:String){
    override fun toString(): String {
        return courseTitle
    }
}

data class NoteInfo(var course:CourseInfo, var noteTitle:String, var noteDescription:String)

data class Book(val title: String, val author: String): java.io.Serializable{
    var description: String? = null
    var imageURL: Int? = null
}