package com.example.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()
    val books = ArrayList<Book>()

    /*
                init block
        - Doesn't accept parameters since it cannot be initialised
        - can access the primary constructor properties of a class
        - called when the class/object is initialised
     */

    init {
        initializeCourses()
        initializeNotes()
        initializeBooks()
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

    private fun initializeNotes(){
        val note = courses["java_core"]?.let { NoteInfo(it, "introduction to java programming", "Lessons on java primitives, reference types, Generics and the collection interface") }
        val note1 = courses["intents"]?.let { NoteInfo(it, "introduction to java programming", "Lessons on java primitives, reference types, Generics and the collection interface") }
        val note2 = courses["android_async"]?.let { NoteInfo(it, "introduction to java programming", "Lessons on java primitives, reference types, Generics and the collection interface") }
        val note3 = courses["java_lang"]?.let { NoteInfo(it, "introduction to java programming", "Lessons on java primitives, reference types, Generics and the collection interface") }

        if (note != null && note1 != null && note2 != null && note3 != null) {
            notes.add(note)
            notes.add(note1)
            notes.add(note2)
            notes.add(note3)
        }

    }

    private fun initializeBooks(){
        val book = Book("Think Big", "Ben Carson").apply {
            this.description = "The core Think Big projects included the construction of the Mobil synthetic-petrol plant at Motunui, the complementary expansion of the Marsden Point Oil Refinery near Whangarei, and the building of a stand-alone plant at Waitara to produce methanol for export. Motunui converted natural gas from the off-shore Maui field to methanol, which it then converted to petrol on-site. Declining oil prices rendered this process uneconomic and saw a reduction in the production of synthetic fuel; however, the industry still remained at large due to prior investment. New Zealand would abandon the manufacturing of synthetic petrol in February 1997, allowing the plant to switch the focus to methanol.[3]."
            this.imageURL = R.drawable.think
        }
        val book1 = Book("The Great Gatsby", "F. Scott Fitzgerald").apply {
            this.description = "In spring 1922, Nick Carraway—a Yale alumnus from the Midwest and a World War I veteran—journeys to New York City to obtain employment as a bond salesman. He rents a bungalow in the Long Island village of West Egg, next to a luxurious estate inhabited by Jay Gatsby, an enigmatic multi-millionaire who hosts dazzling soirées yet doesn't partake in them."
            this.imageURL = R.drawable.gatsby
        }
        val book2 = Book("Hamlet", "William Shakespeare").apply {
            this.description = "Prince Hamlet of Denmark is the son of the recently deceased King Hamlet, and nephew of King Claudius, his father's brother and successor. Claudius hastily married King Hamlet's widow, Gertrude, Hamlet's mother, and took the throne for himself. Denmark has a long-standing feud with neighbouring Norway, in which King Hamlet slew King Fortinbras of Norway in a battle some years ago. Although Denmark defeated Norway and the Norwegian throne fell to King Fortinbras's infirm brother, Denmark fears that an invasion led by the dead Norwegian king's son, Prince Fortinbras, is imminent."
            this.imageURL = R.drawable.hamlet
        }
        val book3 = Book("Moby Dick", "Herman Melville").apply {
            this.description = "Ishmael travels in December from Manhattan Island to New Bedford, Massachusetts, with plans to sign up for a whaling voyage. The inn where he arrives is overcrowded, so he must share a bed with the tattooed cannibal Polynesian Queequeg, a harpooneer whose father was king of the fictional island of Rokovoko. The next morning, Ishmael and Queequeg attend Father Mapple's sermon on Jonah, then head for Nantucket. Ishmael signs up with the Quaker ship-owners Bildad and Peleg for a voyage on their whaler Pequod. Peleg describes Captain Ahab: \"He's a grand, ungodly, god-like man\" who nevertheless \"has his humanities\". They hire Queequeg the following morning. A man named Elijah prophesies a dire fate should Ishmael and Queequeg join Ahab. While provisions are loaded, shadowy figures board the ship. On a cold Christmas Day, the Pequod leaves the harbor."
            this.imageURL = R.drawable.moby
        }
        val book4 = Book("Lost Time", "Marcel Proust").apply {
            this.description = "The Narrator begins by noting, \"For a long time, I went to bed early.\" He comments on the way in which sleep seems to alter one's surroundings, and the way habit makes one indifferent to them. He remembers being in his room in the family's country home in Combray, while downstairs his parents entertain their friend Charles Swann, an elegant man of Jewish origin with strong ties to society. Due to Swann's visit, the Narrator is deprived of his mother's goodnight kiss, but he gets her to spend the night reading to him. This memory is the only one he has of Combray until years later the taste of a madeleine cake dipped in tea inspires a nostalgic incident of involuntary memory. He remembers having a similar snack as a child with his invalid aunt Léonie, and it leads to more memories of Combray. He describes their servant Françoise, who is uneducated but possesses an earthy wisdom and a strong sense of both duty and tradition. He meets an elegant \"lady in pink\" while visiting his uncle Adolphe. He develops a love of the theater, especially the actress Berma, and his awkward Jewish friend Bloch introduces him to the works of the writer Bergotte. He learns Swann made an unsuitable marriage but has social ambitions for his beautiful daughter Gilberte."
            this.imageURL = R.drawable.time
        }
        val book5 = Book("Ulysses", "James Joyce").apply {
            this.description = "At 8 a.m., Malachi “Buck” Mulligan, a boisterous medical student, calls aspiring writer Stephen Dedalus up to the roof of the Sandycove Martello tower, where they both live. There is tension between Dedalus and Mulligan stemming from a cruel remark Stephen overheard Mulligan make about his recently deceased mother and from the fact that Mulligan has invited an English student, Haines, to stay with them. The three men eat breakfast and walk to the shore, where Mulligan demands from Stephen the key to the tower and a loan. The three make plans to meet at a pub, The Ship, at 12:30pm. Departing, Stephen decides that he will not return to the tower that night, as Mulligan, the \"usurper\", has taken it over."
            this.imageURL = R.drawable.ulyses
        }
        books.add(book)
        books.add(book1)
        books.add(book2)
        books.add(book3)
        books.add(book4)
        books.add(book5)

    }

}