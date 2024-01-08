package onim.test.notification

import org.springframework.stereotype.Service

@Service
class NotificationService {
    fun sendNotification(message: String) {
        println("Sending notification <$message>")
    }
}