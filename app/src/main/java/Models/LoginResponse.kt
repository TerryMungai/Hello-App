package Models

import layout.SerializedName

class LoginResponse (
    @SerializedName("access_token") var accessToken: String,
    @SerializedName("message") var message: String
    )

