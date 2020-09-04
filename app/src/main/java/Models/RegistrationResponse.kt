package layout

class RegistrationResponse {
    @SerializedName("message") var message: String,
    @SerializedName("student") var student: Student,

}