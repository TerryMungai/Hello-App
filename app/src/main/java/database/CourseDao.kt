package database


interface CourseDao{
    @Insert(onConflict=onConflictsstrategy.REPLACE)
    fun insertCourse(Course: Course)
    @Query(value)
}
