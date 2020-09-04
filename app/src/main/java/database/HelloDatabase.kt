package database

import androidx.room.Database

class HelloDatabase {
}

@ Database(entities = arrayOf(Courses::class), version = 1)
abstract class HelloDatabase:
