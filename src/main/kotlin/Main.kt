package ru.netology

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream
import ru.netology.constants


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val serviceAccount =
        FileInputStream("fcm.json")

    val options: FirebaseOptions = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    FirebaseApp.initializeApp(options)
    newPost()
    newLike()
}

fun newPost()
{
    val message = Message.builder()
        .putData("action", "NEWPOST")
        .putData("content", """{
            "userId": 1,
            "userName": "test",
            "postId": 144,
            "content": "Lorem ipsum blablabla"
        }""".trimMargin())
        .setToken(constants.token)
        .build()
    FirebaseMessaging.getInstance().send(message)
}

fun newLike()
{
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
            "userId": 1,
            "userName": "test",
            "postId": 1,
            "postAuthor": "Netology"
        }""".trimMargin())
        .setToken(constants.token)
        .build()
    FirebaseMessaging.getInstance().send(message)
}