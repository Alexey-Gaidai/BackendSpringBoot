package com.example.BackendSpringBoot.model

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private const val ICON_LINK_PATTERN = "https://openweathermap.org/img/w/"
private const val ICON_LINK_FORMAT = ".png"

@Entity
@Table
class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(nullable = false)
    var datetime: Long = 0

    @Column
    var city: String = ""

    @Column
    var max: Double = 0.0

    @Column
    var current: Double = 0.0

    @Column
    var min: Double = 0.0

    @Column
    var description: String = ""

    @Column
    var icon: String = ""
        set(value) {
            field = getIconLink(value)
        }

    @Column
    var windSpeed: Double = 0.0

    @Column
    var windDeg: Int = 0

    @Column
    var dtTxt: String = ""

    private fun getIconLink(value: String): String {
        return ICON_LINK_PATTERN + value + ICON_LINK_FORMAT
    }
}